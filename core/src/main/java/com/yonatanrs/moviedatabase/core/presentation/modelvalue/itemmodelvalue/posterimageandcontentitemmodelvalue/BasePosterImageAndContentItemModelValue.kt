package com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.posterimageandcontentitemmodelvalue

import android.content.Context
import com.yonatanrs.moviedatabase.core.domain.entity.Dimension
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.BaseItemModelValue

abstract class BasePosterImageAndContentItemModelValue: BaseItemModelValue() {
    abstract val image: Any?
    abstract val dimension: Dimension?
    abstract val title: String?
    abstract val description: String?
    abstract val onClickListener: ((Context) -> Unit)?
}