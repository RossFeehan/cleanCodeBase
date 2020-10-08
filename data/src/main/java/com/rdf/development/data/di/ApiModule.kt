package com.rdf.development.data.di

import com.rdf.development.data.networking.api.CatApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [NetworkingModule::class])
class ApiModule {

    @Provides
    fun provideCatApi(retrofit: Retrofit): CatApi = retrofit.create(CatApi::class.java)
}