package com.rdf.development.data.networking.api

import com.rdf.development.data.model.DataCatFact
import io.reactivex.Single
import retrofit2.http.GET


interface CatApi {

    @GET("/dataFacts/random")
    fun getCatFact(): Single<DataCatFact>
}