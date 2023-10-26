package com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue

import com.yonatanrs.moviedatabase.core.domain.entity.movie.MovieDetail

data class MovieDetailHeaderModelValue(
    override val id: String,
    val movieDetail: MovieDetail,
    override val tag: Any? = null
): BaseItemModelValue()