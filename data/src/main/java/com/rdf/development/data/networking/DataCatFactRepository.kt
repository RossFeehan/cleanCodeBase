package com.rdf.development.data.networking

import com.rdf.development.data.mapper.CatFactMappper
import com.rdf.development.data.networking.api.CatApi
import com.rdf.development.domain.model.CatFact
import com.rdf.development.domain.repository.CatFactRepository
import io.reactivex.Single

class DataCatFactRepository constructor(private val catApi: CatApi): CatFactRepository {

    override fun getCatFact(): Single<CatFact> {
        return catApi.getCatFact()
            .map { CatFactMappper.dataCatFactToDomain(it)  }
    }
}