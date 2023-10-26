package com.yonatanrs.moviedatabase.core.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yonatanrs.moviedatabase.core.data.datasource.database.dao.PopularMovieDao
import com.yonatanrs.moviedatabase.core.data.datasource.database.dao.TopRatedMovieDao
import com.yonatanrs.moviedatabase.core.data.datasource.database.dao.UpcomingMovieDao
import com.yonatanrs.moviedatabase.core.data.datasource.database.entity.PopularMovieEntity
import com.yonatanrs.moviedatabase.core.data.datasource.database.entity.TopRatedMovieEntity
import com.yonatanrs.moviedatabase.core.data.datasource.database.entity.UpcomingMovieEntity

@Database(entities = [PopularMovieEntity::class, TopRatedMovieEntity::class, UpcomingMovieEntity::class], version = 1)
abstract class MovieCatalogDatabase: RoomDatabase() {
    abstract fun popularMovieDao(): PopularMovieDao
    abstract fun topRatedMovieDao(): TopRatedMovieDao
    abstract fun upcomingMovieDao(): UpcomingMovieDao
}