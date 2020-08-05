package com.training.pagingsample.data.network

import com.training.pagingsample.data.network.response.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("3/discover/movie?sort_by=vote_count.desc")
    suspend fun getPopularMovies(
        @Query("page") page: Int
    ) : Response<MovieListResponse>
}