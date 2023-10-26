package com.yonatanrs.moviedatabase.presentation.epoxycontroller

import android.content.Context
import com.yonatanrs.moviedatabase.core.domain.entity.genre.Genre
import com.yonatanrs.moviedatabase.core.presentation.EpoxyModelResult
import com.yonatanrs.moviedatabase.core.presentation.epoxycontroller.BasePagingDataEpoxyController
import com.yonatanrs.moviedatabase.core.presentation.epoxymodel.SingleTextCardEpoxyModel_
import com.yonatanrs.moviedatabase.core.presentation.epoxymodel.TitleAndDescriptionEpoxyModel_
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.GenreItemModelValue
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.titleanddescriptionitemmodelvalue.TitleAndDescriptionItemModelValue
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
class MovieGenrePagingDataEpoxyController(
    private val onClickListener: ((Context, Genre) -> Unit)? = null
): BasePagingDataEpoxyController<BaseModelValue>() {
    override fun buildEachDefaultItemModel(currentPosition: Int, item: BaseModelValue?): EpoxyModelResult {
        return when (item) {
            is TitleAndDescriptionItemModelValue -> {
                EpoxyModelResult.Model(
                    TitleAndDescriptionEpoxyModel_().id(item.id)
                        .spanSizeOverride { _, _, _ -> this.spanCount }
                        .title("Genre")
                        .description("Movie genre.")
                )
            }
            else -> super.buildEachDefaultItemModel(currentPosition, item)
        }
    }

    override fun buildEachItemModel(currentPosition: Int, item: BaseModelValue?): EpoxyModelResult {
        return if (item is GenreItemModelValue) {
            EpoxyModelResult.Model(
                SingleTextCardEpoxyModel_().id("movie-genre-${item.genre.id}")
                    .spanSizeOverride { _, _, _ -> 1 }
                    .title(item.genre.name)
                    .onClickListener { context ->
                        item.genre.also { genre ->
                            onClickListener?.invoke(context, genre)
                        }
                    }
            )
        } else {
            EpoxyModelResult.Failed(item)
        }
    }
}