package com.yonatanrs.moviedatabase.core.data.datasource.paging.moviepagingsource

import com.yonatanrs.moviedatabase.core.data.repository.MovieRepository
import com.yonatanrs.moviedatabase.core.domain.entity.PagingResult
import com.yonatanrs.moviedatabase.core.ext.addAllMovie
import com.yonatanrs.moviedatabase.core.presentation.LoadDataResult
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.SeparatorItemModelValue
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.titleanddescriptionitemmodelvalue.TitleAndDescriptionItemModelValue

class UpcomingMoviePagingSource(private val movieRepository: MovieRepository): BaseMoviePagingSource() {
    override suspend fun getPagingResult(page: Int): LoadDataResult<PagingResult<BaseModelValue>> {
        return movieRepository.getUpcomingMovieList(page).let {
            when (it) {
                is LoadDataResult.Success -> {
                    val newResult: MutableList<BaseModelValue> = mutableListOf()
                    if (page == 1) {
                        newResult.add(TitleAndDescriptionItemModelValue("title_and_description_upcoming_movie", null, null))
                        newResult.add(SeparatorItemModelValue("separator_popular_movie"))
                    }
                    newResult.addAllMovie(it.value)
                    LoadDataResult.Success(PagingResult(it.value.page, newResult, it.value.totalPages, it.value.totalResults))
                }
                is LoadDataResult.Failed -> LoadDataResult.Failed(it.t)
            }
        }
    }
}