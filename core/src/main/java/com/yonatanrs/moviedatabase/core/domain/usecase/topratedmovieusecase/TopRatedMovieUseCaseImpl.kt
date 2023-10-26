package com.yonatanrs.moviedatabase.core.domain.usecase.topratedmovieusecase

import androidx.paging.Pager
import androidx.paging.PagingData
import com.yonatanrs.moviedatabase.core.Config
import com.yonatanrs.moviedatabase.core.data.datasource.paging.moviepagingsource.TopRatedMoviePagingSource
import com.yonatanrs.moviedatabase.core.data.repository.MovieRepository
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TopRatedMovieUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository
): TopRatedMovieUseCase {
    override fun getTopRatedMoviePagingDataFlow(): Flow<PagingData<BaseModelValue>> {
        return Pager(
            config = Config.DEFAULT_PAGING_CONFIG,
            pagingSourceFactory = { TopRatedMoviePagingSource(movieRepository) }
        ).flow
    }
}