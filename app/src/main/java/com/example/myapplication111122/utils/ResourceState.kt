package com.example.myapplication111122.utils


sealed class ResourceState<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T?) : ResourceState<T>(data = data)
    class Error<T>(message: String?) : ResourceState<T>(message = message)
    class Loading<T> : ResourceState<T>()
}