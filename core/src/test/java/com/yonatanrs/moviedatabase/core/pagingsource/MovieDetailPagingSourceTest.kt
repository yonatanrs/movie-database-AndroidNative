package com.yonatanrs.moviedatabase.core.pagingsource

import androidx.paging.PagingSource
import com.yonatanrs.moviedatabase.core.CoroutineTestRule
import com.yonatanrs.moviedatabase.core.MockHelper
import com.yonatanrs.moviedatabase.core.data.datasource.content.LocalMovieDataSource
import com.yonatanrs.moviedatabase.core.data.datasource.content.MovieDataSource
import com.yonatanrs.moviedatabase.core.data.datasource.paging.MovieDetailPagingSource
import com.yonatanrs.moviedatabase.core.data.repository.MovieRepository
import com.yonatanrs.moviedatabase.core.data.repository.MovieRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
class MovieDetailPagingSourceTest {
    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    private lateinit var movieDataSource: MovieDataSource
    private lateinit var localMovieDataSource: LocalMovieDataSource
    private lateinit var movieRepository: MovieRepository
    private lateinit var movieDetailPagingSource: MovieDetailPagingSource

    @Before
    fun before() {
        movieDataSource = mock()
        localMovieDataSource = mock()
        movieRepository = MovieRepositoryImpl(coroutineTestRule.testCoroutineDispatcher, movieDataSource, localMovieDataSource)
        movieDetailPagingSource = MovieDetailPagingSource(movieRepository, 1)
    }

    @Test
    fun loadPagingSource_isSuccessLoad() {
        runBlockingTest {
            val movieDetail = MockHelper.getMovieDetail()
            whenever(movieDataSource.getMovieDetail(1)).thenReturn(movieDetail)

            val loadResult = movieDetailPagingSource.load(
                PagingSource.LoadParams.Refresh(1, 20, false)
            )
            Assert.assertTrue(loadResult is PagingSource.LoadResult.Page)
            Assert.assertTrue((loadResult as PagingSource.LoadResult.Page).data.isNotEmpty())
        }
    }

    @Test
    fun loadPagingSource_isFailedLoad() {
        runBlockingTest {
            val exception = IllegalStateException()
            whenever(movieDataSource.getMovieDetail(1)).thenThrow(exception)

            val loadResult = movieDetailPagingSource.load(
                PagingSource.LoadParams.Refresh(1, 20, false)
            )
            Assert.assertTrue(loadResult is PagingSource.LoadResult.Error)
            Assert.assertEquals((loadResult as PagingSource.LoadResult.Error).throwable, exception)
        }
    }
}