package com.yonatanrs.moviedatabase.core.di.module

import com.yonatanrs.moviedatabase.core.data.datasource.database.MovieCatalogDatabase
import com.yonatanrs.moviedatabase.core.data.datasource.database.dao.PopularMovieDao
import com.yonatanrs.moviedatabase.core.data.datasource.database.dao.TopRatedMovieDao
import com.yonatanrs.moviedatabase.core.data.datasource.database.dao.UpcomingMovieDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {
    @Provides
    @Singleton
    fun providePopularMovieDao(movieCatalogDatabase: MovieCatalogDatabase): PopularMovieDao {
        return movieCatalogDatabase.popularMovieDao()
    }

    @Provides
    @Singleton
    fun provideUpcomingMovieDao(movieCatalogDatabase: MovieCatalogDatabase): UpcomingMovieDao {
        return movieCatalogDatabase.upcomingMovieDao()
    }

    @Provides
    @Singleton
    fun provideTopRatedMovieDao(movieCatalogDatabase: MovieCatalogDatabase): TopRatedMovieDao {
        return movieCatalogDatabase.topRatedMovieDao()
    }
}