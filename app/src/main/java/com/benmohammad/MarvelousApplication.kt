package com.benmohammad

import android.app.Application
import com.benmohammad.marvelous.BuildConfig
import com.benmohammad.marvelous.di.networkModule
import com.benmohammad.marvelous.di.persistenceModule
import com.benmohammad.marvelous.di.repositoryModule
import com.benmohammad.marvelous.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import timber.log.Timber

class MarvelousApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MarvelousApplication)
            modules(viewModelModule)
            modules(networkModule)
            modules (persistenceModule)
            modules(repositoryModule)
        }

        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())

        }
    }


}