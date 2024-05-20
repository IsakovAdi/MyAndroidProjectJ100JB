package com.example.menuoptions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        textView = findViewById(R.id.textView)
        val address = intent.getStringExtra("Address")
        textView.text = address
    }
}