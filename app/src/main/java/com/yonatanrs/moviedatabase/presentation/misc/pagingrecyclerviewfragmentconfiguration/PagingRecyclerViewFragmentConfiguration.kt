package com.yonatanrs.moviedatabase.presentation.misc.pagingrecyclerviewfragmentconfiguration

import com.yonatanrs.moviedatabase.core.presentation.errorprovider.BaseErrorProvider
import com.yonatanrs.moviedatabase.core.presentation.errorprovider.DefaultErrorProvider
import kotlinx.coroutines.ObsoleteCoroutinesApi

@ObsoleteCoroutinesApi
class PagingRecyclerViewFragmentConfiguration(
    val pagingRecyclerViewFragmentValue: PagingRecyclerViewFragmentValue,
    val pagingRecyclerViewFragmentLayoutManagerConfiguration: PagingRecyclerViewFragmentLayoutManagerConfiguration,
    val errorProvider: BaseErrorProvider = DefaultErrorProvider()
)