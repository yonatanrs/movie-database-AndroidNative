package com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.posterimageitemmodelvalue

import android.content.Context
import com.yonatanrs.moviedatabase.core.domain.entity.Dimension

data class PosterImageItemModelValue(
    override val id: String = "",
    override val image: Any?,
    override val dimension: Dimension? = null,
    override val onClickListener: ((Context) -> Unit)? = null,
    override val tag: Any? = null
): BasePosterImageItemModelValue()