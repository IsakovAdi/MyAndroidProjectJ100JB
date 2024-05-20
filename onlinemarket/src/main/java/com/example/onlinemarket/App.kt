package com.example.onlinemarket

import android.app.Application
import com.example.onlinemarket.di.appModule
import com.example.onlinemarket.di.dataModule
import com.example.onlinemarket.di.domainModule
import com.parse.Parse
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build()
        )

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App)
            modules(listOf(dataModule, domainModule, appModule))
        }
    }
}