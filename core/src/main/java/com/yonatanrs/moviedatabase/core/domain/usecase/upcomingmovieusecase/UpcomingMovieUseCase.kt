package com.yonatanrs.moviedatabase.core.domain.usecase.upcomingmovieusecase

import androidx.paging.PagingData
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import kotlinx.coroutines.flow.Flow

interface UpcomingMovieUseCase {
    fun getUpcomingMoviePagingDataFlow(): Flow<PagingData<BaseModelValue>>
}