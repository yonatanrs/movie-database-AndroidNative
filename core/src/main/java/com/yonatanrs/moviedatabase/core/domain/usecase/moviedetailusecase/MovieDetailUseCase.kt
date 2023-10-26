package com.yonatanrs.moviedatabase.core.domain.usecase.moviedetailusecase

import androidx.paging.PagingData
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import kotlinx.coroutines.flow.Flow

interface MovieDetailUseCase {
    fun getMovieDetailPagingDataFlow(movieId: Int): Flow<PagingData<BaseModelValue>>
}