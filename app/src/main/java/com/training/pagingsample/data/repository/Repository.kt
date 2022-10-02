package com.training.pagingsample.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.training.pagingsample.data.model.Movie
import com.training.pagingsample.data.model.Result
import com.training.pagingsample.data.network.Api
import com.training.pagingsample.data.network.response.MovieListResponse
import com.training.pagingsample.data.repository.paged.MoviePagingSource
import kotlinx.coroutines.flow.Flow

class Repository(private val service: Api) {

    fun getMovieListStream(): Flow<PagingData<Movie>> {
        return Pager(PagingConfig(20)) {
            MoviePagingSource(service)
        }.flow
    }
}