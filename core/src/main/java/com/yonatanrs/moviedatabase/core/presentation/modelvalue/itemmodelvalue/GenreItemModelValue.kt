package com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue

import com.yonatanrs.moviedatabase.core.domain.entity.genre.Genre

data class GenreItemModelValue(
    val genre: Genre,
    override val tag: Any? = null
): BaseItemModelValue()