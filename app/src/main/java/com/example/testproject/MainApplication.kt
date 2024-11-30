package com.example.testproject

import android.app.Application

class MainApplication : Application() {
    companion object{
        lateinit var myApp: MainApplication
    }

    override fun onCreate() {
        super.onCreate()
        myApp = this
    }


}