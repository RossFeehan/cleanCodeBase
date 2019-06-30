package com.rdf.development.data.di

import com.rdf.development.data.networking.DataCatFactRepository
import com.rdf.development.data.networking.api.CatApi
import com.rdf.development.domain.repository.CatFactRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideCatFactRepository(catApi: CatApi): CatFactRepository = DataCatFactRepository(catApi)
}