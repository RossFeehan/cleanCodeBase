package com.rdf.development.cleancodebase.feature.catFact

import com.rdf.development.domain.contracts.viewModels.DomainCatFactViewModel
import com.rdf.development.domain.models.CatFact
import com.rdf.development.domain.useCase.feature.GetCatFactUseCase
import io.reactivex.Single
import javax.inject.Inject


class CatFactViewModel @Inject constructor(private val getCatFactUseCase: GetCatFactUseCase):
    DomainCatFactViewModel {

    override fun getCatFact(): Single<CatFact> {
        return getCatFactUseCase.get()
    }
}