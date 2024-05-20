package com.example.newsproject.presentation.main_activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.newsproject.R
import com.example.newsproject.databinding.ActivityMainBinding
import com.example.newsproject.presentation.NewsAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    val adapter = NewsAdapter()

    private val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getAllNews()

        viewModel.allNewsResponse.observe(this) {
            adapter.setNewsList(it.articles)
        }

    }
}