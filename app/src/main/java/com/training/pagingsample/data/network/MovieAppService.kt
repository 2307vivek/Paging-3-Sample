package com.training.pagingsample.data.network

import com.training.pagingsample.data.model.Result
import com.training.pagingsample.data.network.Api
import com.training.pagingsample.data.network.BaseService
import com.training.pagingsample.data.network.response.MovieListResponse

class MovieAppService(private val api: Api) : BaseService() {

    suspend fun fetchPopularMovies(page: Int) : Result<MovieListResponse> {
        return createCall { api.getPopularMovies(page) }
    }
}