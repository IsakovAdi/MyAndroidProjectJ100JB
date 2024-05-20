package com.example.webview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.webview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val defaultUrl = "https://mail.ru/"
        val url = intent.getStringExtra("url")

        binding.webView.webViewClient = MyWebViewClient()
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.loadUrl(url ?: defaultUrl)

    }

    inner class MyWebViewClient : WebViewClient() {

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?,
        ): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }
    }

    override fun onBackPressed() {
        if (binding.webView.canGoBack() == true) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}