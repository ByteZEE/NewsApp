package com.rafi.core.util

sealed class ResultState<out T> {
    data class Success<T>(val data: T): ResultState<T>()
    data class Error<T>(val message: Throwable): ResultState<Nothing>()
    data object Loading: ResultState<Nothing>()
}