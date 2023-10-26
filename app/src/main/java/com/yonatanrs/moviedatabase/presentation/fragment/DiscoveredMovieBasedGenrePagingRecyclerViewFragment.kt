package com.yonatanrs.moviedatabase.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.paging.PagingData
import com.yonatanrs.moviedatabase.presentation.misc.pagingrecyclerviewfragmentconfiguration.PagingRecyclerViewFragmentConfiguration
import com.yonatanrs.moviedatabase.core.presentation.epoxycontroller.BasePagingDataEpoxyController
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import com.yonatanrs.moviedatabase.core.viewmodel.DiscoveredMovieBasedGenreViewModel
import com.yonatanrs.moviedatabase.core.viewmodel.PagingDataViewModel
import com.yonatanrs.moviedatabase.presentation.Constant
import com.yonatanrs.moviedatabase.presentation.epoxycontroller.DiscoverMovieBasedGenrePagingDataEpoxyController
import com.yonatanrs.moviedatabase.presentation.misc.pagingrecyclerviewfragmentconfiguration.copy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ObsoleteCoroutinesApi
@AndroidEntryPoint
class DiscoveredMovieBasedGenrePagingRecyclerViewFragment: BasePagingRecyclerViewFragment<BaseModelValue>() {
    private val discoveredMovieBasedGenreViewModel: DiscoveredMovieBasedGenreViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (basePagingDataEpoxyController as DiscoverMovieBasedGenrePagingDataEpoxyController).also {
            discoveredMovieBasedGenreViewModel.bindParallelLoadingResult()
            discoveredMovieBasedGenreViewModel.parallelLoadingResultLiveData.observe(this.viewLifecycleOwner) { result ->
                it.bindParallelLoadingResult(result)
            }
            discoveredMovieBasedGenreViewModel.parallelLiveData.observe(this.viewLifecycleOwner) { _ ->
                it.requestModelBuild()
            }
        }
    }

    override fun getPagingDataEpoxyController(): BasePagingDataEpoxyController<BaseModelValue> {
        return DiscoverMovieBasedGenrePagingDataEpoxyController(
            onAddModels = { id, modelValue ->
                discoveredMovieBasedGenreViewModel.loadingParallel(id, modelValue)
            }
        )
    }

    override fun getPagingDataViewModel(): PagingDataViewModel {
        return discoveredMovieBasedGenreViewModel
    }

    override fun getPagingDataFlow(): Flow<PagingData<BaseModelValue>> {
        return discoveredMovieBasedGenreViewModel.getDiscoveredMovieBasedGenrePagingDataFlow(
            this.requireArguments().getInt(Constant.ARGUMENT_GENRE_ID)
        )
    }

    override fun getPagingRecyclerViewFragmentConfiguration(): PagingRecyclerViewFragmentConfiguration {
        return super.getPagingRecyclerViewFragmentConfiguration().copy(spanCount = 2)
    }
}