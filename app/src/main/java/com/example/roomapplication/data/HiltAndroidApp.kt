package com.example.roomapplication.data

import android.app.Application
import android.content.Context

@dagger.hilt.android.HiltAndroidApp
class HiltAndroidApp: Application() {
    init {
        instance = this
    }

    companion object {
        lateinit var instance: HiltAndroidApp

        fun applicationContext(): Context{
            return instance.applicationContext
        }
    }
}