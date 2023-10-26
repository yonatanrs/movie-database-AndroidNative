package com.yonatanrs.moviedatabase.presentation.misc.pagingrecyclerviewfragmentconfiguration

data class PagingRecyclerViewFragmentValue(
    val spanCount: Int,
    val itemSpacingDp: Int,
    val startLoadFirst: Boolean = true
)