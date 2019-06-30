package com.rdf.development.data.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class HttpClientModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()
}
