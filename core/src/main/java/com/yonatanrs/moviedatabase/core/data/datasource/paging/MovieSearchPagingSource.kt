package com.yonatanrs.moviedatabase.core.data.datasource.paging

import com.yonatanrs.moviedatabase.core.data.repository.MovieRepository
import com.yonatanrs.moviedatabase.core.domain.entity.PagingResult
import com.yonatanrs.moviedatabase.core.ext.addAllMovie
import com.yonatanrs.moviedatabase.core.presentation.LoadDataResult
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.SeparatorItemModelValue
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.itemmodelvalue.titleanddescriptionitemmodelvalue.TitleAndDescriptionItemModelValue

class MovieSearchPagingSource(
    private val movieRepository: MovieRepository,
    private val search: String
): BasedIntKeyedPagingSource<BaseModelValue>() {
    override suspend fun getPagingResult(page: Int): LoadDataResult<PagingResult<BaseModelValue>> {
        return movieRepository.searchMovie(page, search).let {
            when (it) {
                is LoadDataResult.Success -> {
                    val newResult: MutableList<BaseModelValue> = mutableListOf()
                    if (page == 1) {
                        newResult.add(
                            TitleAndDescriptionItemModelValue(
                                id = "title_and_description_search_result",
                                title = "Search Result",
                                description = "Search result based \"${search}\""
                            )
                        )
                        newResult.add(SeparatorItemModelValue("separator_genre"))
                    }
                    newResult.addAllMovie(it.value)
                    LoadDataResult.Success(PagingResult(it.value.page, newResult, it.value.totalPages, it.value.totalResults))
                }
                is LoadDataResult.Failed -> LoadDataResult.Failed(it.t)
            }
        }
    }
}