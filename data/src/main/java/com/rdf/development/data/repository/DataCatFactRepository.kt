package com.rdf.development.data.repository

import com.rdf.development.data.mapper.DataCatFactMappper
import com.rdf.development.data.networking.api.CatApi
import com.rdf.development.domain.models.CatFact
import com.rdf.development.domain.contracts.repository.CatFactRepository
import io.reactivex.Single

class DataCatFactRepository constructor(private val catApi: CatApi): CatFactRepository {

    override fun getCatFact(): Single<CatFact> {
        return catApi.getCatFact()
            .map { DataCatFactMappper.dataCatFactToDomain(it)  }
    }
}