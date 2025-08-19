package com.example.adminhealth.application

import android.app.Application
import com.example.adminhealth.utils.PreferenceAdmin
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AdminHealthApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceAdmin(this)
    }
}