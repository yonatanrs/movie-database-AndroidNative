package com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.posterimageitemmodelvalue

import android.content.Context
import com.yonatanrs.moviedatabase.core.domain.entity.Dimension
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.BaseItemModelValue

abstract class BasePosterImageItemModelValue: BaseItemModelValue() {
    abstract val image: Any?
    abstract val dimension: Dimension?
    abstract val onClickListener: ((Context) -> Unit)?
}