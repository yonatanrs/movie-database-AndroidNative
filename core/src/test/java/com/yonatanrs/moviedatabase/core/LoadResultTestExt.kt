package com.yonatanrs.moviedatabase.core

import com.yonatanrs.moviedatabase.core.presentation.LoadDataResult

fun<T> getValueFromSuccessLoadResult(loadDataResult: LoadDataResult<T>): T {
    if (loadDataResult is LoadDataResult.Failed) {
        throw loadDataResult.t
    }
    return (loadDataResult as LoadDataResult.Success).value
}