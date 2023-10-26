package com.yonatanrs.moviedatabase.core.domain.usecase.genremovieusecase

import androidx.paging.PagingData
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import kotlinx.coroutines.flow.Flow

interface MovieGenreUseCase {
    fun getMovieGenrePagingDataFlow(): Flow<PagingData<BaseModelValue>>
}