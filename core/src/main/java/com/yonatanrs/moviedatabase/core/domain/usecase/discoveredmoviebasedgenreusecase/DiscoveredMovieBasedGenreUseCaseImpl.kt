package com.yonatanrs.moviedatabase.core.domain.usecase.discoveredmoviebasedgenreusecase

import androidx.paging.Pager
import androidx.paging.PagingData
import com.yonatanrs.moviedatabase.core.Config
import com.yonatanrs.moviedatabase.core.data.datasource.paging.moviepagingsource.DiscoveredMovieBasedGenrePagingSource
import com.yonatanrs.moviedatabase.core.data.repository.MovieRepository
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DiscoveredMovieBasedGenreUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository
): DiscoveredMovieBasedGenreUseCase {
    override fun getDiscoveredMovieBasedGenrePagingDataFlow(genreId: Int): Flow<PagingData<BaseModelValue>> {
        return Pager(
            config = Config.DEFAULT_PAGING_CONFIG,
            pagingSourceFactory = { DiscoveredMovieBasedGenrePagingSource(movieRepository, genreId) }
        ).flow
    }
}