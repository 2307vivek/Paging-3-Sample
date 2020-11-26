package com.training.pagingsample.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.training.pagingsample.R
import com.training.pagingsample.databinding.MovieItemBinding
import com.training.pagingsample.databinding.MovieItemSeperatorBinding
import com.training.pagingsample.ui.screen.MovieModel

class MovieAdapter : PagingDataAdapter<MovieModel, RecyclerView.ViewHolder>(
    MovieModelComparator
) {

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val movieModel: MovieModel = getItem(position)!!

        movieModel.let {
            when (movieModel) {
                is MovieModel.MovieItem -> {
                    val viewHolder = holder as MovieViewHolder
                    viewHolder.movieItemBinding.movieTitle.text = movieModel.movie.original_title
                    viewHolder.movieItemBinding.movieVoteCount.text =
                        "Vote count ${movieModel.movie.vote_count}"
                }
                is MovieModel.SeparatorItem -> {
                    val viewHolder = holder as MovieSeparatorViewHolder
                    viewHolder.movieItemSeperatorBinding
                        .separatorDescription.text = movieModel.description
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is MovieModel.MovieItem -> R.layout.movie_item
            is MovieModel.SeparatorItem -> R.layout.movie_item_seperator
            null -> throw UnsupportedOperationException("Unknown view")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.movie_item -> {
                MovieViewHolder(
                    MovieItemBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
            else -> {
                MovieSeparatorViewHolder(
                    MovieItemSeperatorBinding
                        .inflate(LayoutInflater.from(parent.context), parent, false)
                )
            }
        }
    }

    class MovieViewHolder(val movieItemBinding: MovieItemBinding) :
        RecyclerView.ViewHolder(movieItemBinding.root)

    class MovieSeparatorViewHolder(val movieItemSeperatorBinding: MovieItemSeperatorBinding) :
        RecyclerView.ViewHolder(movieItemSeperatorBinding.root)

    companion object {
        private val MovieModelComparator = object : DiffUtil.ItemCallback<MovieModel>() {
            override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
                return (oldItem is MovieModel.MovieItem && newItem is MovieModel.MovieItem &&
                        oldItem.movie.id == newItem.movie.id) ||
                        (oldItem is MovieModel.SeparatorItem && newItem is MovieModel.SeparatorItem &&
                                oldItem.description == newItem.description)
            }

            override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean =
                oldItem == newItem
        }
    }

}