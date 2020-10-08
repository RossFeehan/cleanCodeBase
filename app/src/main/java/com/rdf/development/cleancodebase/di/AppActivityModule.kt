package com.rdf.development.cleancodebase.di

import com.rdf.development.cleancodebase.di.annotations.ActivityScope
import com.rdf.development.cleancodebase.feature.catFact.CatFactActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector



@Module(

)
internal abstract class AppActivityModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [])
    internal abstract fun contributeYourAndroidInjector(): CatFactActivity


}