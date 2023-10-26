package com.yonatanrs.moviedatabase.core.viewmodel

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.yonatanrs.moviedatabase.core.domain.usecase.discoveredmoviebasedgenreusecase.DiscoveredMovieBasedGenreUseCase
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class DiscoveredMovieBasedGenreViewModel @Inject constructor(
    private val discoveredMovieBasedGenreUseCase: DiscoveredMovieBasedGenreUseCase
): ParallelLoadingViewModel() {
    fun getDiscoveredMovieBasedGenrePagingDataFlow(genreId: Int): Flow<PagingData<BaseModelValue>> {
        return discoveredMovieBasedGenreUseCase.getDiscoveredMovieBasedGenrePagingDataFlow(genreId).cachedIn(viewModelScope)
    }
}