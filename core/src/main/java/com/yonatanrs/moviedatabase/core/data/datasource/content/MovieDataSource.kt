package com.yonatanrs.moviedatabase.core.data.datasource.content

import com.yonatanrs.moviedatabase.core.domain.entity.PagingResult
import com.yonatanrs.moviedatabase.core.domain.entity.genre.GenreList
import com.yonatanrs.moviedatabase.core.domain.entity.movie.Movie
import com.yonatanrs.moviedatabase.core.domain.entity.movie.MovieDetail
import com.yonatanrs.moviedatabase.core.domain.entity.movie.MovieDetailCredit
import com.yonatanrs.moviedatabase.core.domain.entity.movie.MovieUserReview
import com.yonatanrs.moviedatabase.core.domain.entity.movie.moviedetailimage.MovieDetailImage
import com.yonatanrs.moviedatabase.core.domain.entity.movie.moviedetailvideo.MovieDetailVideo

interface MovieDataSource{
    suspend fun getMovieGenreList(page: Int): GenreList
    suspend fun getPopularMovieList(page: Int): PagingResult<Movie>
    suspend fun getTopRatedMovieList(page: Int): PagingResult<Movie>
    suspend fun getUpcomingMovieList(page: Int): PagingResult<Movie>
    suspend fun getMovieDetail(movieId: Int): MovieDetail
    suspend fun getMovieDetailImage(movieId: Int): MovieDetailImage
    suspend fun getMovieDetailVideo(movieId: Int): MovieDetailVideo
    suspend fun getMovieDetailCredit(movieId: Int): MovieDetailCredit
    suspend fun getMovieRecommendation(movieId: Int, page: Int): PagingResult<Movie>
    suspend fun getMovieUserReview(movieId: Int): PagingResult<MovieUserReview>
    suspend fun getDiscoveredMovieBasedGenre(page: Int, genreId: Int): PagingResult<Movie>
    suspend fun searchMovie(page: Int, query: String): PagingResult<Movie>
}