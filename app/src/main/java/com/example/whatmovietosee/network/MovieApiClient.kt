package com.example.whatmovietosee.network

import com.example.whatmovietosee.data.Constants
import com.example.whatmovietosee.data.MoviesApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieApiClient {

    val apiClient: MoviesApi by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return@lazy retrofit.create(MoviesApi::class.java)
    }

}