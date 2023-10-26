package com.yonatanrs.moviedatabase.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.paging.PagingData
import com.yonatanrs.moviedatabase.core.presentation.epoxycontroller.BasePagingDataEpoxyController
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import com.yonatanrs.moviedatabase.core.viewmodel.PagingDataViewModel
import com.yonatanrs.moviedatabase.core.viewmodel.SearchMovieViewModel
import com.yonatanrs.moviedatabase.presentation.Constant
import com.yonatanrs.moviedatabase.presentation.epoxycontroller.PopularMoviePagingDataEpoxyController
import com.yonatanrs.moviedatabase.presentation.misc.SearchMoviePagingCommand
import com.yonatanrs.moviedatabase.presentation.misc.pagingrecyclerviewfragmentconfiguration.PagingRecyclerViewFragmentConfiguration
import com.yonatanrs.moviedatabase.presentation.misc.pagingrecyclerviewfragmentconfiguration.copy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ObsoleteCoroutinesApi
@AndroidEntryPoint
class SearchMoviePagingRecyclerViewFragment: BasePagingRecyclerViewFragment<BaseModelValue>() {
    private val searchMovieViewModel: SearchMovieViewModel by viewModels()
    val command: SearchMoviePagingCommand = SearchMoviePagingCommand { search ->
        this.arguments = Bundle().also { it.putString(Constant.ARGUMENT_SEARCH, search) }
        searchMovieViewModel.resetSearchMoviePagingDataFlow()
        triggerCollectPagingData()
    }

    override fun getPagingDataEpoxyController(): BasePagingDataEpoxyController<BaseModelValue> {
        return PopularMoviePagingDataEpoxyController()
    }

    override fun getPagingDataViewModel(): PagingDataViewModel {
        return searchMovieViewModel
    }

    override fun getPagingDataFlow(): Flow<PagingData<BaseModelValue>> {
        return searchMovieViewModel.searchMoviePagingDataFlow(
            this.requireArguments().getString(Constant.ARGUMENT_SEARCH) ?: ""
        )
    }

    override fun getPagingRecyclerViewFragmentConfiguration(): PagingRecyclerViewFragmentConfiguration {
        return super.getPagingRecyclerViewFragmentConfiguration().copy(spanCount = 2, startLoadFirst = false)
    }
}