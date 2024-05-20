package com.example.retrofittutorial.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofittutorial.R
import com.example.retrofittutorial.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<MainViewModel>()

    private val adapter by lazy {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.getPosts()
        observe()
        binding.button.setOnClickListener {
            if (binding.postIdEditText.text.trim().isNotBlank()) {
                viewModel.getCommentsPostsList(binding.postIdEditText.text.toString().toInt())
                observe()
            }
        }

        binding.button2.setOnClickListener {
            viewModel.getSortedPost(
                postId = binding.postIdEditText.text.toString().toInt(),
                sortBy = "id",
                ""
            )
            observe()
        }
    }

    private fun observe() {
        viewModel.posts.observe(this) { posts ->
            posts.forEach { post ->
                Log.d("MY_LOG", "------------------------------")
                Log.d("MY_LOG", post.userId.toString())
                Log.d("MY_LOG", post.postId.toString())
                Log.d("MY_LOG", post.postTitle.toString())
                Log.d("MY_LOG", post.description.toString())
                Log.d("MY_LOG", post.name.toString())
                Log.d("MY_LOG", post.email.toString())
                Log.d("MY_LOG", post.commentsPostId.toString())
                Log.d("MY_LOG", "")
            }
        }
    }
}