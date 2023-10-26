package com.yonatanrs.moviedatabase.core.domain.usecase.discoveredmoviebasedgenreusecase

import androidx.paging.PagingData
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import kotlinx.coroutines.flow.Flow

interface DiscoveredMovieBasedGenreUseCase {
    fun getDiscoveredMovieBasedGenrePagingDataFlow(genreId: Int): Flow<PagingData<BaseModelValue>>
}