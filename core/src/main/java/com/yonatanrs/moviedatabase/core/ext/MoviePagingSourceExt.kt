package com.yonatanrs.moviedatabase.core.ext

import com.yonatanrs.moviedatabase.core.domain.entity.PagingResult
import com.yonatanrs.moviedatabase.core.domain.entity.movie.Movie
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.posterimageitemmodelvalue.PosterImageItemModelValue

fun MutableList<BaseModelValue>.addAllMovie(moviePagingResult: PagingResult<Movie>) {
    moviePagingResult.also {
        this.addAll(it.results.map { movie ->
            PosterImageItemModelValue(id = "poster_image_movie_${movie.id}", image = null, tag = movie)
        })
    }
}