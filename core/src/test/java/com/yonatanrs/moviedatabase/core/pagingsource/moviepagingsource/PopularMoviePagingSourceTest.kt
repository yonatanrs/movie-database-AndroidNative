package com.yonatanrs.moviedatabase.core.pagingsource.moviepagingsource

import androidx.paging.PagingSource
import com.yonatanrs.moviedatabase.core.CoroutineTestRule
import com.yonatanrs.moviedatabase.core.MockHelper
import com.yonatanrs.moviedatabase.core.data.datasource.content.LocalMovieDataSource
import com.yonatanrs.moviedatabase.core.data.datasource.content.MovieDataSource
import com.yonatanrs.moviedatabase.core.data.datasource.paging.moviepagingsource.PopularMoviePagingSource
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
class PopularMoviePagingSourceTest {
    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    private lateinit var movieDataSource: MovieDataSource
    private lateinit var localMovieDataSource: LocalMovieDataSource
    private lateinit var movieRepository: MovieRepository
    private lateinit var popularMoviePagingSource: PopularMoviePagingSource

    @Before
    fun before() {
        movieDataSource = mock()
        localMovieDataSource = mock()
        movieRepository = MovieRepositoryImpl(coroutineTestRule.testCoroutineDispatcher, movieDataSource, localMovieDataSource)
        popularMoviePagingSource = PopularMoviePagingSource(movieRepository)
    }

    @Test
    fun loadPagingSource_isSuccessLoad() {
        runBlockingTest {
            val moviePagingResult = MockHelper.getMoviePagingResult()
            whenever(movieDataSource.getPopularMovieList(1)).thenReturn(moviePagingResult)
            whenever(localMovieDataSource.deletePopularMovieListToDatabase(1)).thenReturn(1)
            whenever(localMovieDataSource.addPopularMovieListToDatabase(1, moviePagingResult)).thenReturn(moviePagingResult)

            val loadResult = popularMoviePagingSource.load(
                PagingSource.LoadParams.Refresh(1, 20, false)
            )
            Assert.assertTrue(loadResult is PagingSource.LoadResult.Page)
            Assert.assertTrue((loadResult as PagingSource.LoadResult.Page).data.isNotEmpty())
        }
    }

    @Test
    fun loadPagingSource_isAlthoughRemoteFailedLoad() {
        runBlockingTest {
            val moviePagingResult = MockHelper.getMoviePagingResult()
            val exception = IllegalStateException()
            whenever(movieDataSource.getPopularMovieList(1)).thenThrow(exception)
            whenever(localMovieDataSource.getPopularMovieList(1)).thenReturn(moviePagingResult)

            val loadResult = popularMoviePagingSource.load(
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
            whenever(movieDataSource.getPopularMovieList(1)).thenThrow(exception)
            whenever(localMovieDataSource.getPopularMovieList(1)).thenThrow(exception)

            val loadResult = popularMoviePagingSource.load(
                PagingSource.LoadParams.Refresh(1, 20, false)
            )
            Assert.assertTrue(loadResult is PagingSource.LoadResult.Error)
            Assert.assertEquals((loadResult as PagingSource.LoadResult.Error).throwable, exception)
        }
    }
}