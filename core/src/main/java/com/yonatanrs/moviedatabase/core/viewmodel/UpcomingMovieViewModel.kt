package com.yonatanrs.moviedatabase.core.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.yonatanrs.moviedatabase.core.domain.usecase.upcomingmovieusecase.UpcomingMovieUseCase
import com.yonatanrs.moviedatabase.core.misc.flow.FlowWrapper
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class UpcomingMovieViewModel @Inject constructor(
    private val upcomingMovieUseCase: UpcomingMovieUseCase
): PagingDataViewModel() {
    private val upcomingMoviePagingDataFlowWrapper: FlowWrapper<PagingData<BaseModelValue>> = FlowWrapper()

    fun getUpcomingMoviePagingDataFlow(): Flow<PagingData<BaseModelValue>> {
        return upcomingMoviePagingDataFlowWrapper.assignFlow {
            upcomingMovieUseCase.getUpcomingMoviePagingDataFlow().cachedIn(viewModelScope)
        }.flow
    }
}