package com.yonatanrs.moviedatabase.core.viewmodel

import androidx.lifecycle.ViewModel

abstract class PagingDataViewModel: ViewModel() {
    var refreshWithSwiping = false
}