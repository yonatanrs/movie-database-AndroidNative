package com.yonatanrs.moviedatabase.core.presentation.epoxymodel

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.yonatanrs.moviedatabase.core.R
import com.yonatanrs.moviedatabase.core.presentation.epoxyholder.ErrorEpoxyHolder
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.ErrorItemModelValue

@EpoxyModelClass
abstract class ErrorEpoxyModel: EpoxyModelWithHolder<ErrorEpoxyHolder>() {
    @EpoxyAttribute
    var errorItemModelValue: ErrorItemModelValue? = null

    override fun getDefaultLayout(): Int {
        return R.layout.item_error
    }

    override fun bind(holder: ErrorEpoxyHolder) {
        super.bind(holder)
        errorItemModelValue?.also {
            it.errorProviderResult.also { errorProviderResult ->
                holder.titleTextView.text = errorProviderResult.title
                holder.descriptionTextView.text = errorProviderResult.message
                //errorProviderResult.iconResId?.also { value -> holder.iconImageView.setImageResource(value) }
                holder.retryButton.setOnClickListener { view -> it.onRetry?.invoke(view.context) }
            }
        }
    }
}