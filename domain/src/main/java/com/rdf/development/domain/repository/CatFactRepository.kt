package com.rdf.development.domain.repository

import com.rdf.development.domain.model.CatFact
import io.reactivex.Single


interface CatFactRepository {

    fun getCatFact(): Single<CatFact>
}