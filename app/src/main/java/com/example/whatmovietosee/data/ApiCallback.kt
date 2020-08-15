package com.example.whatmovietosee.data

interface ApiCallback<T> {
    fun onSuccess(data: T)
    fun onError(message: String)
}