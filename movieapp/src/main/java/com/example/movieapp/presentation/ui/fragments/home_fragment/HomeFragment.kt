package com.example.movieapp.presentation.ui.fragments.home_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ScrollView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentHomeBinding
import com.example.movieapp.presentation.model.MovieModel
import com.example.movieapp.presentation.ui.adapters.MovieAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(), MovieAdapter.MovieItemClickListener,
    AdapterView.OnItemSelectedListener {

    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<HomeFragmentViewModel>()

    private val adapter by lazy {
        MovieAdapter(this)
    }

    private val spinnerAdapter by lazy {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.movie_types,
            android.R.layout.simple_spinner_item
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View = binding.root


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
        initSpinner()
        setClickers()
    }

    private fun observeViewModel() {
        viewModel.apply {
            movies.observe(viewLifecycleOwner) {
                adapter.setNewMovies(it)
                binding.scrollView.fullScroll(ScrollView.FOCUS_UP)
                binding.pageTv.isVisible = true
                binding.previousBtn.isVisible = true
                binding.nextBtn.isVisible = true
            }
            errorMessage.observe(viewLifecycleOwner) {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
            currentPage.observe(viewLifecycleOwner) {
                binding.pageTv.text = it.toString()
            }
        }
    }

    private fun initSpinner() {
        binding.apply {

            moviesRv.adapter = adapter
            spinner.onItemSelectedListener = this@HomeFragment
            spinner.adapter = spinnerAdapter
        }
    }

    private fun setClickers() {
        binding.apply {
            nextBtn.setOnClickListener {
                viewModel.nextPage()
            }
            previousBtn.setOnClickListener {
                viewModel.previousPage()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getMovie()
    }

    override fun onclick(movie: MovieModel) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment2(movie)
        )
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        when(position){
            0-> viewModel.getMovie(MovieType.POPULAR)
            1-> viewModel.getMovie(MovieType.NOW_PLAYING)
            2-> viewModel.getMovie(MovieType.TOP_RATED)
            3-> viewModel.getMovie(MovieType.UPCOMING)
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}