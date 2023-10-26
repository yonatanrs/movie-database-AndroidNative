package com.yonatanrs.moviedatabase.presentation.epoxycontroller

import android.content.Context
import android.content.Intent
import com.yonatanrs.moviedatabase.core.domain.entity.movie.Movie
import com.yonatanrs.moviedatabase.core.presentation.EpoxyModelResult
import com.yonatanrs.moviedatabase.core.presentation.epoxycontroller.BasePagingDataEpoxyController
import com.yonatanrs.moviedatabase.core.presentation.epoxymodel.posterimageepoxymodel.PosterImageEpoxyModel_
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.posterimageitemmodelvalue.PosterImageItemModelValue
import com.yonatanrs.moviedatabase.presentation.Constant
import com.yonatanrs.moviedatabase.presentation.activity.MovieDetailActivity
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
open class MoviePagingDataEpoxyController(
    private val onClickListener: ((Context, Movie) -> Unit)? = null,
    onAddModels: ((String, BaseModelValue) -> Unit)? = null
): BasePagingDataEpoxyController<BaseModelValue>(onAddModels = onAddModels) {
    override fun buildEachItemModel(currentPosition: Int, item: BaseModelValue?): EpoxyModelResult {
        return if (item is PosterImageItemModelValue) {
            if (item.tag is Movie) {
                val movie = item.tag as Movie
                EpoxyModelResult.Model(
                    PosterImageEpoxyModel_().id("movie-poster-image-${movie.id}")
                        .spanSizeOverride { _, _, _ -> 1 }
                        .posterImageItemModelValue(
                            item.copy(
                                image = movie.posterPath?.toString(),
                                onClickListener = { context ->
                                    movie.also { movie ->
                                        onClickListener?.invoke(context, movie) ?: Intent(
                                            context, MovieDetailActivity::class.java
                                        ).also {
                                            it.putExtra(Constant.ARGUMENT_MOVIE_ID, movie.id)
                                            context.startActivity(it)
                                        }
                                    }
                                }
                            )
                        )
                )
            } else {
                throw IllegalStateException("Item tag must be movie.")
            }
        } else {
            EpoxyModelResult.Failed(item)
        }
    }
}