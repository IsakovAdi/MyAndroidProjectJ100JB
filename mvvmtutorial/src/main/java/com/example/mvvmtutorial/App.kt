package com.example.mvvmtutorial

import android.app.Application
import com.example.mvvmtutorial.di.dataModule
import com.example.mvvmtutorial.di.domainModule
import com.example.mvvmtutorial.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(appModule, domainModule, dataModule))
        }
    }
}