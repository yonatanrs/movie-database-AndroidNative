package com.yonatanrs.moviedatabase.core.presentation.epoxyholder

import android.widget.TextView
import com.yonatanrs.moviedatabase.core.R

class TitleAndDescriptionEpoxyHolder: KotlinEpoxyHolder() {
    val titleTextView by bind<TextView>(R.id.text_view_title)
    val descriptionTextView by bind<TextView>(R.id.text_view_description)
}