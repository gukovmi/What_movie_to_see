package com.example.whatmovietosee.top_rated_movies.di

import com.example.whatmovietosee.data.Constants
import com.example.whatmovietosee.data.MoviesApi
import com.example.whatmovietosee.data.MoviesRepositoryImpl
import com.example.whatmovietosee.data.NetworkMoviesDataSourceImpl
import com.example.whatmovietosee.top_rated_movies.domain.GetTopRatedMoviesUseCase
import com.example.whatmovietosee.top_rated_movies.domain.TopRatedMoviesModelImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TopRatedMoviesModelFactory {
    fun create(): TopRatedMoviesModelImpl {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val api=retrofit.create(MoviesApi::class.java)

        val networkNoteDataSource = NetworkMoviesDataSourceImpl(api)
        val moviesRepository=MoviesRepositoryImpl(networkNoteDataSource)
        val getTopRatedMoviesUseCase=GetTopRatedMoviesUseCase(moviesRepository)

        return TopRatedMoviesModelImpl(getTopRatedMoviesUseCase)
    }
}