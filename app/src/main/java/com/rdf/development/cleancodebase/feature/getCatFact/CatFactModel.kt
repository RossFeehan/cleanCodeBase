package com.rdf.development.cleancodebase.feature.getCatFact

import com.rdf.development.domain.model.CatFact
import com.rdf.development.domain.useCase.feature.GetCatFactUseCase
import io.reactivex.Single
import javax.inject.Inject


class CatFactModel @Inject constructor(private val getCatFactUseCase: GetCatFactUseCase): GetCatFactContract.Model {

    override fun getCatFact(): Single<CatFact> {
        return getCatFactUseCase.get()
    }
}