package com.yonatanrs.moviedatabase.core.presentation.modelvalue.compoundmodelvalue.carouselcompoundmodelvalue

import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.BaseItemModelValue

data class CarouselCompoundPlaceholderModelValue(
    override val id: String,
    override val tag: Any? = null
): BaseItemModelValue()