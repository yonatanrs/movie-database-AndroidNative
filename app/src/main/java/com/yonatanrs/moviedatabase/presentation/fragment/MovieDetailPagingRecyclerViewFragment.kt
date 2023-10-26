package com.yonatanrs.moviedatabase.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.paging.PagingData
import com.yonatanrs.moviedatabase.core.presentation.epoxycontroller.BasePagingDataEpoxyController
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import com.yonatanrs.moviedatabase.core.viewmodel.MovieDetailViewModel
import com.yonatanrs.moviedatabase.core.viewmodel.PagingDataViewModel
import com.yonatanrs.moviedatabase.presentation.Constant
import com.yonatanrs.moviedatabase.presentation.epoxycontroller.MovieDetailPagingDataEpoxyController
import com.yonatanrs.moviedatabase.presentation.misc.pagingrecyclerviewfragmentconfiguration.PagingRecyclerViewFragmentConfiguration
import com.yonatanrs.moviedatabase.presentation.misc.pagingrecyclerviewfragmentconfiguration.copy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ObsoleteCoroutinesApi
@AndroidEntryPoint
class MovieDetailPagingRecyclerViewFragment: BasePagingRecyclerViewFragment<BaseModelValue>() {
    private val movieDetailViewModel: MovieDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (basePagingDataEpoxyController as MovieDetailPagingDataEpoxyController).also {
            movieDetailViewModel.bindParallelLoadingResult()
            movieDetailViewModel.parallelLoadingResultLiveData.observe(this.viewLifecycleOwner) { result ->
                it.bindParallelLoadingResult(result)
            }
            movieDetailViewModel.parallelLiveData.observe(this.viewLifecycleOwner) { _ ->
                it.requestModelBuild()
            }
        }
    }

    override fun getPagingDataEpoxyController(): BasePagingDataEpoxyController<BaseModelValue> {
        return MovieDetailPagingDataEpoxyController(
            onAddModels = { id, modelValue ->
                movieDetailViewModel.loadingParallel(id, modelValue)
            }
        )
    }

    override fun getPagingDataViewModel(): PagingDataViewModel {
        return movieDetailViewModel
    }

    override fun getPagingDataFlow(): Flow<PagingData<BaseModelValue>> {
        return movieDetailViewModel.getMovieGenrePagingDataFlow(this.requireArguments().getInt(Constant.ARGUMENT_MOVIE_ID))
    }

    override fun getPagingRecyclerViewFragmentConfiguration(): PagingRecyclerViewFragmentConfiguration {
        return super.getPagingRecyclerViewFragmentConfiguration().copy(spanCount = 2)
    }
}