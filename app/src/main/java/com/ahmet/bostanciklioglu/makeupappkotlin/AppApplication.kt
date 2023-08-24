package com.ahmet.bostanciklioglu.makeupappkotlin

import android.app.Application
import com.squareup.picasso.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        //Timber set up
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}