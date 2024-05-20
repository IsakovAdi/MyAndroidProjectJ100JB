package com.example.newsproject.base

import android.app.Application
import com.example.newsproject.di.appModule
import com.example.newsproject.di.dataModule
import com.example.newsproject.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(dataModule, domainModule, appModule))
        }
    }
}