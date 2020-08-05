package com.training.pagingsample.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.training.pagingsample.R
import com.training.pagingsample.ui.screen.MovieModel
import kotlinx.android.synthetic.main.movie_item.view.*
import kotlinx.android.synthetic.main.movie_item_seperator.view.*

class MovieAdapter : PagingDataAdapter<MovieModel, RecyclerView.ViewHolder>(
    MovieModelComparator
){

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val movieModel: MovieModel = getItem(position)!!

        movieModel.let {
            when(movieModel){
                is MovieModel.MovieItem -> {
                    val viewHolder = holder as MovieViewHolder
                    viewHolder.itemView.movie_title.text = movieModel.movie.original_title
                    viewHolder.itemView.movie_voteCount.text = "Vote count ${movieModel.movie.vote_count.toString()}"
                }
                is MovieModel.SeparatorItem -> {
                    val viewHolder = holder as MovieSeparatorViewHolder
                    viewHolder.itemView.separator_description.text = movieModel.description
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(getItem(position)){
            is MovieModel.MovieItem -> R.layout.movie_item
            is MovieModel.SeparatorItem -> R.layout.movie_item_seperator
            null -> throw UnsupportedOperationException("Unknown view")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            R.layout.movie_item -> {
                MovieViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.movie_item, parent, false)
                )
            }
            else -> {
                MovieSeparatorViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.movie_item_seperator, parent, false)
                )
            }
        }
    }

    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view)
    class MovieSeparatorViewHolder(view: View) : RecyclerView.ViewHolder(view)

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