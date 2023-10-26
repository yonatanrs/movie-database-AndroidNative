package com.yonatanrs.moviedatabase.core.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.yonatanrs.moviedatabase.core.domain.usecase.moviedetailusecase.MovieDetailUseCase
import com.yonatanrs.moviedatabase.core.misc.flow.FlowWrapper
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailUseCase: MovieDetailUseCase
): ParallelLoadingViewModel() {
    private val movieDetailPagingDataFlowWrapper: FlowWrapper<PagingData<BaseModelValue>> = FlowWrapper()

    fun getMovieGenrePagingDataFlow(movieId: Int): Flow<PagingData<BaseModelValue>> {
        return movieDetailPagingDataFlowWrapper.assignFlow {
            movieDetailUseCase.getMovieDetailPagingDataFlow(movieId).cachedIn(viewModelScope)
        }.flow
    }
}