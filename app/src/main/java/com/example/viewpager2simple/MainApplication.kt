package com.example.viewpager2simple

import android.app.Application
import com.example.viewpager2simple.di.myApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@MainApplication)
            // declare modules
            modules(myApp)
        }
    }
}