package com.yonatanrs.moviedatabase.core.presentation.modelvalue.compoundmodelvalue.carouselcompoundmodelvalue

import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.BaseItemModelValue

data class CarouselCompoundModelValue(
    override val id: String,
    override val itemModelValueList: List<BaseItemModelValue>,
    override val tag: Any? = null
): BaseCarouselCompoundModelValue()