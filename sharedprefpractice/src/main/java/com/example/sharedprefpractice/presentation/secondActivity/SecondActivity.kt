package com.example.sharedprefpractice.presentation.secondActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedprefpractice.R
import com.example.sharedprefpractice.databinding.ActivitySecondBinding
import com.example.sharedprefpractice.presentation.mainActivity.ItemAdapter

class SecondActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    private val viewModel by lazy {
        SecondViewModel(this)
    }

    private val itemsAdapter by lazy {
        ItemAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.secondRv.adapter = itemsAdapter

        viewModel.items.observe(this) {
            itemsAdapter.addItems(it)
        }

        binding.button.setOnClickListener {
            viewModel.getData()
        }


    }
}