package com.rdf.development.domain.contracts.viewModels

import com.rdf.development.domain.models.CatFact
import io.reactivex.Single


interface DomainCatFactViewModel {

    fun getCatFact(): Single<CatFact>
}