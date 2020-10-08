package com.rdf.development.cleancodebase.di

import com.rdf.development.cleancodebase.feature.catFact.CatFactViewModel
import com.rdf.development.domain.contracts.viewModels.DomainCatFactViewModel
import com.rdf.development.domain.useCase.feature.GetCatFactUseCase
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideCatFactViewModel(getCatFactUseCase: GetCatFactUseCase): DomainCatFactViewModel = CatFactViewModel(getCatFactUseCase)
}