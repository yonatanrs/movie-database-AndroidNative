package com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.titleanddescriptionitemmodelvalue

import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.BaseItemModelValue

data class TitleAndDescriptionPlaceholderItemModelValue(
    override val id: String,
    override val tag: Any? = null
): BaseItemModelValue()