package com.example.myhealth.application

import android.app.Application
import com.example.myhealth.utils.Preference
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyHealthApplication: Application() {
    override fun onCreate() {
        Preference(this)
        super.onCreate()
    }
}