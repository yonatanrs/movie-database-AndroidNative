package com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue

import com.yonatanrs.moviedatabase.core.domain.entity.urlstring.ImageUrlString

data class ImageItemModelValue(
    val imageUrlString: ImageUrlString
): BaseItemModelValue()