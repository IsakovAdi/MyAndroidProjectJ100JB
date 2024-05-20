package com.example.mvvmtutorial.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmtutorial.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModel<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel.getText()

        binding.apply {
            viewModel.savedText.observe(this@MainActivity) { text ->
                savedText.text = text
            }
            saveBtn.setOnClickListener {
                val text = inputText.text.toString()
                viewModel.saveText(text)
            }
        }
    }
}