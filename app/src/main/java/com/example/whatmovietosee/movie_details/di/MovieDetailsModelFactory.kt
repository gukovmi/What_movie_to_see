package com.example.whatmovietosee.movie_details.di

import com.example.whatmovietosee.data.Constants
import com.example.whatmovietosee.data.MoviesApi
import com.example.whatmovietosee.data.MoviesRepositoryImpl
import com.example.whatmovietosee.data.NetworkMoviesDataSourceImpl
import com.example.whatmovietosee.movie_details.domain.GetImagesByIdUseCase
import com.example.whatmovietosee.movie_details.domain.GetMovieByIdUseCase
import com.example.whatmovietosee.movie_details.domain.GetVideosByIdUseCase
import com.example.whatmovietosee.movie_details.domain.MovieDetailsModelImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MovieDetailsModelFactory {
    fun create(): MovieDetailsModelImpl {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()

        val api = retrofit.create(MoviesApi::class.java)

        val networkNoteDataSource = NetworkMoviesDataSourceImpl(api)
        val moviesRepository = MoviesRepositoryImpl(networkNoteDataSource)
        val getMovieByIdUseCase = GetMovieByIdUseCase(moviesRepository)
        val getVideosByIdUseCase = GetVideosByIdUseCase(moviesRepository)
        val getImageByIdUseCase = GetImagesByIdUseCase(moviesRepository)

        return MovieDetailsModelImpl(getMovieByIdUseCase, getVideosByIdUseCase, getImageByIdUseCase)
    }
}