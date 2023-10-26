package com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue

import com.yonatanrs.moviedatabase.core.domain.entity.movie.Movie

data class MovieItemModelValue(
    val movie: Movie,
    override val tag: Any? = null
): BaseItemModelValue()