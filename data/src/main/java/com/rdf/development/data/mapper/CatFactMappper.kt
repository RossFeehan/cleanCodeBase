package com.rdf.development.data.mapper

import com.rdf.development.data.model.DataCatFact
import com.rdf.development.domain.models.CatFact

class CatFactMappper {

    companion object {

        fun dataCatFactToDomain(dataCatFact: DataCatFact): CatFact{
            return CatFact(id = dataCatFact.id,
                fact = dataCatFact.fact)
        }
    }
}