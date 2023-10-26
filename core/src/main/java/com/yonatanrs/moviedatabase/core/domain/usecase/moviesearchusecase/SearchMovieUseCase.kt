package com.yonatanrs.moviedatabase.core.domain.usecase.moviesearchusecase

import androidx.paging.PagingData
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import kotlinx.coroutines.flow.Flow

interface SearchMovieUseCase {
    fun searchMoviePagingDataFlow(search: String): Flow<PagingData<BaseModelValue>>
}