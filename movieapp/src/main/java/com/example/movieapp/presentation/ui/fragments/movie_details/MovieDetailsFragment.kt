package com.example.movieapp.presentation.ui.fragments.movie_details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentMovieDetailsBinding
import com.example.movieapp.presentation.ui.Utils
import com.example.movieapp.presentation.ui.adapters.MovieImageAdapterHorizontal
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsFragment : Fragment() {

    private val args by navArgs<MovieDetailsFragmentArgs>()
    private val binding by lazy {
        FragmentMovieDetailsBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<MovieDetailsViewModel>()

    private val similarMoviesAdapter by lazy {
        MovieImageAdapterHorizontal()
    }

    private val recommendMoviesAdapter by lazy {
        MovieImageAdapterHorizontal()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setMovieUi()
        viewModel.getData(args.movie.movieId)
        observe()
    }

    private fun setMovieUi() {
        val movie = args.movie
        with(binding) {
            similarMoviesRv.adapter = similarMoviesAdapter
            recommendMoviesRv.adapter = recommendMoviesAdapter
            Picasso.get().load(Utils.POSTER_PATH_URL + movie.horizontalImage).into(movieImage)
            originalLanguage.text = movie.originalLanguage
            title.text = movie.movieTitle
            popularity.text = movie.popularity.toString()
            voteCount.text = movie.voteCount.toString()
            voteAverage.rating = movie.voteAverage.toFloat()
            originalTitle.text = movie.originalTitle
            relaseDate.text = movie.releaseDate
            overivew.text = movie.description
            toolbarTitle.text = movie.movieTitle
            Picasso.get().load(Utils.POSTER_PATH_URL + movie.posterImage).into(posterImageView)
        }
    }


    private fun observe() {
        viewModel.apply {
            similarMovies.observe(viewLifecycleOwner) {
                similarMoviesAdapter.setNewMovies(it)
            }
            recommendMovies.observe(viewLifecycleOwner){
                recommendMoviesAdapter.setNewMovies(it)
            }
        }
    }
}