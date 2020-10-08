package com.rdf.development.cleancodebase.di

import com.rdf.development.cleancodebase.feature.catFact.CatFactContract
import com.rdf.development.cleancodebase.feature.catFact.CatFactPresenter
import com.rdf.development.domain.contracts.viewModels.DomainCatFactViewModel
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun provideCatFacePresenter(catFactViewModel: DomainCatFactViewModel): CatFactContract.Presenter = CatFactPresenter(catFactViewModel)
}