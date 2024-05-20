package com.example.onlinemarket.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.onlinemarket.R
import com.example.onlinemarket.databinding.ActivityRootBinding

class RootActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityRootBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val navView = binding.toorBottomNavView
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.root_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        navView.setupWithNavController(navController)
    }
}