package com.yonatanrs.moviedatabase.core.presentation

import com.airbnb.epoxy.EpoxyModel
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue

sealed class EpoxyModelResult {
    class Model(val epoxyModel: EpoxyModel<*>): EpoxyModelResult()
    class Failed(val item: BaseModelValue?): EpoxyModelResult()
}