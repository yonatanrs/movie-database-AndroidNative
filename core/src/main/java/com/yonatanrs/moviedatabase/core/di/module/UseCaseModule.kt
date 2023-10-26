package com.yonatanrs.moviedatabase.core.di.module

import com.yonatanrs.moviedatabase.core.domain.usecase.discoveredmoviebasedgenreusecase.DiscoveredMovieBasedGenreUseCase
import com.yonatanrs.moviedatabase.core.domain.usecase.discoveredmoviebasedgenreusecase.DiscoveredMovieBasedGenreUseCaseImpl
import com.yonatanrs.moviedatabase.core.domain.usecase.genremovieusecase.MovieGenreUseCase
import com.yonatanrs.moviedatabase.core.domain.usecase.genremovieusecase.MovieGenreUseCaseImpl
import com.yonatanrs.moviedatabase.core.domain.usecase.moviedetailusecase.MovieDetailUseCase
import com.yonatanrs.moviedatabase.core.domain.usecase.moviedetailusecase.MovieDetailUseCaseImpl
import com.yonatanrs.moviedatabase.core.domain.usecase.moviesearchusecase.SearchMovieUseCase
import com.yonatanrs.moviedatabase.core.domain.usecase.moviesearchusecase.SearchMovieUseCaseImpl
import com.yonatanrs.moviedatabase.core.domain.usecase.popularmovieusecase.PopularMovieUseCase
import com.yonatanrs.moviedatabase.core.domain.usecase.popularmovieusecase.PopularMovieUseCaseImpl
import com.yonatanrs.moviedatabase.core.domain.usecase.topratedmovieusecase.TopRatedMovieUseCase
import com.yonatanrs.moviedatabase.core.domain.usecase.topratedmovieusecase.TopRatedMovieUseCaseImpl
import com.yonatanrs.moviedatabase.core.domain.usecase.upcomingmovieusecase.UpcomingMovieUseCase
import com.yonatanrs.moviedatabase.core.domain.usecase.upcomingmovieusecase.UpcomingMovieUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindPopularMovieUseCaseImpl(popularMovieUseCaseImpl: PopularMovieUseCaseImpl): PopularMovieUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindDiscoveredMovieBasedGenreUseCaseImpl(discoveredMovieBasedGenreUseCaseImpl: DiscoveredMovieBasedGenreUseCaseImpl): DiscoveredMovieBasedGenreUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindTopRatedMovieUseCaseImpl(topRatedMovieUseCaseImpl: TopRatedMovieUseCaseImpl): TopRatedMovieUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUpcomingMovieUseCaseImpl(upcomingMovieUseCaseImpl: UpcomingMovieUseCaseImpl): UpcomingMovieUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindUpcomingMovieGenreUseCaseImpl(movieGenreUseCaseImpl: MovieGenreUseCaseImpl): MovieGenreUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindMovieDetailUseCaseImpl(movieDetailUseCaseImpl: MovieDetailUseCaseImpl): MovieDetailUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindMovieSearchUseCaseImpl(movieSearchUseCaseImpl: SearchMovieUseCaseImpl): SearchMovieUseCase
}