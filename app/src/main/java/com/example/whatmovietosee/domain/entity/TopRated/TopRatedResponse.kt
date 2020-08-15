package com.example.whatmovietosee.domain.entity.TopRated

import com.google.gson.annotations.SerializedName

class TopRatedResponse (
    var page: Int,
    var results: List<Movie>,
    @SerializedName("total_results")
    var totalResults: Int,
    @SerializedName("total_pages")
    var totalPages: Int
)