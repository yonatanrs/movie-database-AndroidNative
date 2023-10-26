package com.yonatanrs.moviedatabase.core.presentation.modelvalue.compoundmodelvalue.carouselcompoundmodelvalue

import com.yonatanrs.moviedatabase.core.presentation.modelvalue.compoundmodelvalue.BaseCompoundModelValue
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.BaseItemModelValue

abstract class BaseCarouselCompoundModelValue: BaseCompoundModelValue() {
    abstract val itemModelValueList: List<BaseItemModelValue>
}