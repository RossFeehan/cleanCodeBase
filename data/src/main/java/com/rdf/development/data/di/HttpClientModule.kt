package com.rdf.development.data.di

import com.rdf.development.data.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

@Module
class HttpClientModule {

    @Provides
    fun provideOkHttpClient(): OkHttpClient{
        val clientBuilder = OkHttpClient.Builder()

        if(BuildConfig.DEBUG){
            clientBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        return clientBuilder.build()
    }
}
