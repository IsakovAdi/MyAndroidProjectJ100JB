package com.example.movieapp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.databinding.MovieImageItemHorBinding
import com.example.movieapp.presentation.model.MovieModel
import com.example.movieapp.presentation.ui.Utils
import com.squareup.picasso.Picasso

class MovieImageAdapterHorizontal() :
    RecyclerView.Adapter<MovieImageAdapterHorizontal.ViewHolder>() {
    private val movies = mutableListOf<MovieModel>()

    inner class ViewHolder(val binding: MovieImageItemHorBinding) :
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        MovieImageItemHorBinding.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_image_item_hor, parent, false)
        )
    )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun setNewMovies(newMovies: List<MovieModel>) {
        movies.clear()
        movies.addAll(newMovies)
        notifyDataSetChanged()
    }
}