package com.rdf.development.cleancodebase.di

import com.rdf.development.cleancodebase.application.CleanCodeApplication
import com.rdf.development.data.di.ApiModule
import com.rdf.development.data.di.RepositoryModule
import com.rdf.development.domain.base.executor.PostExecutionThread
import com.rdf.development.domain.base.transformer.SchedulerTransformer
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppActivityModule::class,
        PresenterModule::class,
        ViewModelModule::class,
        ApplicationModule::class,
        ApiModule::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    fun inject(app: CleanCodeApplication)

    fun provideSchedularTransformer(): SchedulerTransformer
    fun providePostExecutionThread(): PostExecutionThread

}