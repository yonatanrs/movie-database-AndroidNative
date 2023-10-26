package com.yonatanrs.moviedatabase.core.misc.parallelloading

import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue

class ParallelLoadingResult(
    val parallelLoadingCompoundModelValueId: String,
    val oldBaseModelValue: List<BaseModelValue>,
    val newBaseModelValue: List<BaseModelValue>
)