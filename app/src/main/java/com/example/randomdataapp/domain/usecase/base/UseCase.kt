package com.example.randomdataapp.domain.usecase.base

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

abstract class UseCase<in P, R> {
    operator fun invoke(params: P): Flow<ResultStatus<R>> = flow {
        emit(ResultStatus.Loading)
        emit(doWork(params))
    }.catch { throwable ->
        Log.e("throwable", throwable.toString())
        emit(ResultStatus.Error(throwable))
    }
    protected abstract suspend fun doWork(params: P): ResultStatus<R>
}