package com.yonatanrs.moviedatabase.core.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.yonatanrs.moviedatabase.core.domain.usecase.genremovieusecase.MovieGenreUseCase
import com.yonatanrs.moviedatabase.core.misc.flow.FlowWrapper
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MovieGenreViewModel @Inject constructor(
    private val movieGenreUseCase: MovieGenreUseCase
): PagingDataViewModel() {
    private val topRatedMoviePagingDataFlowWrapper: FlowWrapper<PagingData<BaseModelValue>> = FlowWrapper()

    fun getMovieGenrePagingDataFlow(): Flow<PagingData<BaseModelValue>> {
        return topRatedMoviePagingDataFlowWrapper.assignFlow {
            movieGenreUseCase.getMovieGenrePagingDataFlow().cachedIn(viewModelScope)
        }.flow
    }
}