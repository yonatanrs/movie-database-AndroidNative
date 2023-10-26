package com.yonatanrs.moviedatabase.core.domain.usecase.popularmovieusecase

import androidx.paging.PagingData
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import kotlinx.coroutines.flow.Flow

interface PopularMovieUseCase {
    fun getPopularMoviePagingDataFlow(): Flow<PagingData<BaseModelValue>>
}