package com.yonatanrs.moviedatabase.core.di.module

import com.yonatanrs.moviedatabase.core.data.repository.MovieRepository
import com.yonatanrs.moviedatabase.core.data.repository.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindMovieRepositoryImpl(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}