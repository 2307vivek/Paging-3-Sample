package com.training.pagingsample

import android.app.Application
import com.training.movieapp.di.viewModelModule
import com.training.pagingsample.di.networkModule
import com.training.pagingsample.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@MovieApp)
            modules(listOf(networkModule, repositoryModule, viewModelModule))
        }
    }
}