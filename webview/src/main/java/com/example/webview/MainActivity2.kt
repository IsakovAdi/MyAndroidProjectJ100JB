package com.example.webview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.webview.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
            youtube.setOnClickListener {
                openUrlScreen("https://www.youtube.com/")
            }
            url1.setOnClickListener {
                openUrlScreen("https://www.facebook.com/")
            }
            url2.setOnClickListener {
                openUrlScreen("https://ru.freepik.com/photos/%D1%8F%D1%80%D0%BA%D0%B8%D0%B5-%D0%BA%D0%B0%D1%80%D1%82%D0%B8%D0%BD%D0%BA%D0%B8")
            }
            url3.setOnClickListener {
                openUrlScreen("https://www.google.com/")
            }
        }
    }

    private fun openUrlScreen(url:String){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("url", url)
        startActivity(intent)
    }
}