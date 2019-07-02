package com.rdf.development.cleancodebase.application

import android.app.Activity
import android.app.Application
import com.rdf.development.cleancodebase.di.AppComponent
import com.rdf.development.cleancodebase.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class CleanCodeApplication: Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        configureInjection()
    }

    private fun configureInjection() {
        appComponent = createAppComponent()
        appComponent.inject(this)
    }

    private fun createAppComponent(): AppComponent {
        return DaggerAppComponent.builder()
            .build()
    }

    override fun activityInjector(): AndroidInjector<Activity?> {
        return dispatchingAndroidInjector
    }
}