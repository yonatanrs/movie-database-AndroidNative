package com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.titleanddescriptionitemmodelvalue

import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.BaseItemModelValue

abstract class BaseTitleAndDescriptionItemModelValue: BaseItemModelValue() {
    override val id: String = ""
    open val title: String? = null
    open val description: String? = null
    override val tag: Any? = null
}