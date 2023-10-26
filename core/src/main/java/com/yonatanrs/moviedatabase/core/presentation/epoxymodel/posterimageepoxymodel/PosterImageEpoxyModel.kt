package com.yonatanrs.moviedatabase.core.presentation.epoxymodel.posterimageepoxymodel

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.yonatanrs.moviedatabase.core.R
import com.yonatanrs.moviedatabase.core.presentation.epoxyholder.posterimageepoxyholder.PosterImageEpoxyHolder
import com.yonatanrs.moviedatabase.core.presentation.epoxymodel.HasLeftRightPaddingEpoxyModel
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.posterimageitemmodelvalue.PosterImageItemModelValue

@EpoxyModelClass
abstract class PosterImageEpoxyModel: EpoxyModelWithHolder<PosterImageEpoxyHolder>(), HasLeftRightPaddingEpoxyModel {
    private val posterImageEpoxyModelBinder: PosterImageEpoxyModelBinder = PosterImageEpoxyModelBinder()

    @EpoxyAttribute
    var posterImageItemModelValue: PosterImageItemModelValue? = null

    override fun getDefaultLayout(): Int {
        return R.layout.item_poster_image
    }

    override fun bind(view: PosterImageEpoxyHolder) {
        super.bind(view)
        posterImageEpoxyModelBinder.bind(view, posterImageItemModelValue)
    }
}