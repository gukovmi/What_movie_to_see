package com.example.whatmovietosee.data

import ImagesResponse
import MovieDetails
import VideosResponse
import android.util.Log
import com.example.whatmovietosee.domain.entity.TopRated.TopRatedResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NetworkMoviesDataSourceImpl(private val api: MoviesApi): NetworkMoviesDataSource  {

    override fun getTopRatedMovies(callback: ApiCallback<TopRatedResponse>, page: Int)  {

       api.getTopRatedMovies(Constants.API_KEY, "ru", page)
            .enqueue(object: Callback<TopRatedResponse> {
                override fun onFailure(call: Call<TopRatedResponse>, t: Throwable) {
                    callback.onError(message = "Ошибка получения фильмов - ${t.localizedMessage}")
                }

                override fun onResponse(
                    call: Call<TopRatedResponse>,
                    response: Response<TopRatedResponse>
                ) {
                    if (response.body()!=null) {
                        callback.onSuccess(data = response.body()!!)
                    }
                    else{
                        callback.onError(message = "response.body()==null")
                    }
                }
            })
    }




    override fun getMovieById(movieId: Int): Call<MovieDetails> =
        api.getMovieById(movieId, Constants.API_KEY, "ru")


    override fun getVideosById(movieId: Int): Call<VideosResponse> =
        api.getVideosById(movieId, Constants.API_KEY, "ru")


    override fun getImagesById(movieId: Int): Call<ImagesResponse> =
        api.getImagesById(movieId, Constants.API_KEY)

}