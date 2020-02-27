package com.example.dictionary.dagger

import android.app.Application

class MyApplication : Application() {
    lateinit var applicationModule: ApplicationModule // Declaring our component instance


    override fun onCreate() {
        super.onCreate()
        applicationModule = DaggerApplicationModule.builder().build()
    }
}