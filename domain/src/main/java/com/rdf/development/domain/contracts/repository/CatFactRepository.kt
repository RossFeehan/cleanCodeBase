package com.rdf.development.domain.contracts.repository

import com.rdf.development.domain.models.CatFact
import io.reactivex.Single


interface CatFactRepository {

    fun getCatFact(): Single<CatFact>
}