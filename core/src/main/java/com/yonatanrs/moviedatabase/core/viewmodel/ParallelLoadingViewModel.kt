package com.yonatanrs.moviedatabase.core.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.yonatanrs.moviedatabase.core.misc.parallelloading.ParallelLoadingManager
import com.yonatanrs.moviedatabase.core.misc.parallelloading.ParallelLoadingResult
import com.yonatanrs.moviedatabase.core.presentation.modelvalue.BaseModelValue
import kotlinx.coroutines.Dispatchers

abstract class ParallelLoadingViewModel: PagingDataViewModel() {
    private val parallelLoadingManager: ParallelLoadingManager = ParallelLoadingManager()
    val parallelLiveData: LiveData<ParallelLoadingResult> = parallelLoadingManager.parallelLiveData
    val parallelLoadingResultLiveData: LiveData<List<ParallelLoadingResult>> = parallelLoadingManager.parallelLoadingResultLiveData

    fun loadingParallel(key: String, baseModelValue: BaseModelValue) {
        parallelLoadingManager.loadingParallel(key, baseModelValue, viewModelScope, Dispatchers.IO)
    }

    fun bindParallelLoadingResult() {
        parallelLoadingManager.bindParallelLoadingResult()
    }

    fun clearParallelLoadingResult() {
        parallelLoadingManager.clearParallelLoadingResult()
    }
}