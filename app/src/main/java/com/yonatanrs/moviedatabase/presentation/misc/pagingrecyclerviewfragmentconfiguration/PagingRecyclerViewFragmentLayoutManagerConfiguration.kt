package com.yonatanrs.moviedatabase.presentation.misc.pagingrecyclerviewfragmentconfiguration

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.yonatanrs.moviedatabase.core.presentation.epoxycontroller.BasePagingDataEpoxyController
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
abstract class PagingRecyclerViewFragmentLayoutManagerConfiguration {
    abstract fun<PagingDataType: BaseModelValue> getPagingRecyclerViewLayoutManager(
        context: Context, pagingRecyclerViewFragmentValue: PagingRecyclerViewFragmentValue,
        pagingDataEpoxyController: BasePagingDataEpoxyController<PagingDataType>
    ): RecyclerView.LayoutManager
}