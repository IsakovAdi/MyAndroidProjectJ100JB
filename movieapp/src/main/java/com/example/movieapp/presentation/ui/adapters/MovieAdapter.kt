package com.example.movieapp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieImageItemBinding
import com.example.movieapp.presentation.model.MovieModel
import com.example.movieapp.presentation.ui.Utils
import com.squareup.picasso.Picasso

class MovieAdapter(val listener: MovieItemClickListener) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    private val movies = mutableListOf<MovieModel>()

    inner class ViewHolder(val binding: MovieImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieModel) {
            Picasso.get().load(Utils.POSTER_PATH_URL + movie.posterImage)
                .into(binding.moviePosterImage)
            val progress = (movie.voteAverage * 10).toInt()
            if (progress >= 72) {
                binding.progressView.setProgressColorRes(R.color.green)
            } else if (progress in 51..71) {
                binding.progressView.setProgressColorRes(R.color.yellow)
            } else {
                binding.progressView.setProgressColorRes(R.color.red)
            }
            binding.progressView.setProgress(progress, true)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.ViewHolder {
        return ViewHolder(
            MovieImageItemBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.movie_image_item, parent, false)
            )
        )
    }

    override fun onBindViewHolder(holder: MovieAdapter.ViewHolder, position: Int) {
        holder.bind(movies[position])
        holder.itemView.setOnClickListener {
            listener.onclick(movies[position])
        }
    }

    override fun getItemCount(): Int = movies.size

    fun setNewMovies(data: List<MovieModel>) {
        movies.clear()
        movies.addAll(data)
        notifyDataSetChanged()
    }

    interface MovieItemClickListener {
        fun onclick(movie: MovieModel)
    }
}