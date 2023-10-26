package com.yonatanrs.moviedatabase.core.presentation.epoxymodel.posterimageandcontentepoxymodel

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.yonatanrs.moviedatabase.core.R
import com.yonatanrs.moviedatabase.core.presentation.epoxyholder.posterimageandcontentepoxyholder.PosterImageAndContentEpoxyHolder
import com.yonatanrs.moviedatabase.core.presentation.epoxymodel.HasLeftRightPaddingEpoxyModel
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.posterimageandcontentitemmodelvalue.PosterImageAndContentItemModelValue

@EpoxyModelClass
abstract class PosterImageAndContentEpoxyModel: EpoxyModelWithHolder<PosterImageAndContentEpoxyHolder>(), HasLeftRightPaddingEpoxyModel {
    private val posterImageAndContentEpoxyModelBinder: PosterImageAndContentEpoxyModelBinder = PosterImageAndContentEpoxyModelBinder()

    @EpoxyAttribute
    var posterImageAndContentItemModelValue: PosterImageAndContentItemModelValue? = null

    override fun getDefaultLayout(): Int {
        return R.layout.item_poster_image_and_content
    }

    override fun bind(view: PosterImageAndContentEpoxyHolder) {
        super.bind(view)
        posterImageAndContentEpoxyModelBinder.bind(view, posterImageAndContentItemModelValue)
    }
}