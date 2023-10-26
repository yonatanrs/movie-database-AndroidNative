package com.yonatanrs.moviedatabase.core.presentation.epoxyholder

import android.view.View
import com.yonatanrs.moviedatabase.core.R

class SeparatorEpoxyHolder: KotlinEpoxyHolder() {
    val spacingView by bind<View>(R.id.view_spacing)
}