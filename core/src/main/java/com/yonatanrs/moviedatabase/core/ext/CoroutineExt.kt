package com.yonatanrs.moviedatabase.core.ext

import com.yonatanrs.moviedatabase.core.presentation.LoadDataResult
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

suspend fun<T> getHttpRequestResult(onGetHttpRequestResult: suspend () -> T): T {
    return try {
        onGetHttpRequestResult()
    } catch (e: Exception) {
        throw e
    }
}

suspend fun<T> getHttpRequestLoadDataResult(
    coroutineContext: CoroutineContext,
    onGetHttpRequestResult: suspend () -> T
): LoadDataResult<T> {
    return try {
        withContext(coroutineContext) {
            LoadDataResult.Success(onGetHttpRequestResult())
        }
    } catch (e: Exception) {
        LoadDataResult.Failed(e)
    }
}