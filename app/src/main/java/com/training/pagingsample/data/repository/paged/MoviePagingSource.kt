package com.training.pagingsample.data.repository.paged

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.training.pagingsample.data.model.Movie
import com.training.pagingsample.data.model.Result
import com.training.pagingsample.data.network.Api

class MoviePagingSource(
    private val service: Api
) : PagingSource<Int, Movie>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {

        return try {
            val nextPage = params.key ?: 1
            val movieListResponse = service.getPopularMovies(nextPage)

            LoadResult.Page(
                data = movieListResponse.results!!,
                prevKey = if (nextPage == 1) null else nextPage - 1 ,
                nextKey = if (nextPage < movieListResponse.totalPages!!)
                    movieListResponse.page?.plus(1) else null
            )
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Movie>): Int {
        return 1
    }
}
