package com.training.pagingsample.data.repository

import com.training.pagingsample.data.model.Result
import com.training.pagingsample.data.network.MovieAppService
import com.training.pagingsample.data.network.response.MovieListResponse

class Repository(private val service: MovieAppService) {

    suspend fun getPopularMovies(page: Int) : MovieListResponse {
        return when(val result = service.fetchPopularMovies(page)){
            is Result.Success -> result.data
            is Result.Error -> throw result.error
        }
    }
}