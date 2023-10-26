package com.yonatanrs.moviedatabase.presentation.fragment

import androidx.fragment.app.viewModels
import androidx.paging.PagingData
import com.yonatanrs.moviedatabase.core.presentation.epoxycontroller.BasePagingDataEpoxyController
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import com.yonatanrs.moviedatabase.core.viewmodel.PagingDataViewModel
import com.yonatanrs.moviedatabase.core.viewmodel.UpcomingMovieViewModel
import com.yonatanrs.moviedatabase.presentation.epoxycontroller.UpcomingMoviePagingDataEpoxyController
import com.yonatanrs.moviedatabase.presentation.misc.pagingrecyclerviewfragmentconfiguration.PagingRecyclerViewFragmentConfiguration
import com.yonatanrs.moviedatabase.presentation.misc.pagingrecyclerviewfragmentconfiguration.copy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ObsoleteCoroutinesApi
@AndroidEntryPoint
class UpcomingMoviePagingRecyclerViewFragment: BasePagingRecyclerViewFragment<BaseModelValue>() {
    private val upcomingMovieViewModel: UpcomingMovieViewModel by viewModels()

    override fun getPagingDataEpoxyController(): BasePagingDataEpoxyController<BaseModelValue> {
        return UpcomingMoviePagingDataEpoxyController()
    }

    override fun getPagingDataViewModel(): PagingDataViewModel {
        return upcomingMovieViewModel
    }

    override fun getPagingDataFlow(): Flow<PagingData<BaseModelValue>> {
        return upcomingMovieViewModel.getUpcomingMoviePagingDataFlow()
    }

    override fun getPagingRecyclerViewFragmentConfiguration(): PagingRecyclerViewFragmentConfiguration {
        return super.getPagingRecyclerViewFragmentConfiguration().copy(spanCount = 2)
    }
}