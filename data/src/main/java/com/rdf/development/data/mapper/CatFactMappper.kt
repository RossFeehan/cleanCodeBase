package com.rdf.development.data.mapper

import com.rdf.development.data.model.DataCatFact
import com.rdf.development.data.model.DataFact
import com.rdf.development.domain.model.CatFact
import com.rdf.development.domain.model.Fact


class CatFactMappper {

    companion object {

        fun dataCatFactToDomain(dataCatFact: DataCatFact): CatFact{
            val facts = mutableListOf<Fact>()
            if(dataCatFact.dataFacts != null){
                for(fact in dataCatFact.dataFacts){
                    mapDataFactToDomain(fact)?.let { facts.add(it) }
                }
            }

            return CatFact(facts)
        }

        private fun mapDataFactToDomain(fact: DataFact): Fact {
            return Fact(id = fact.id,
                fact = fact.fact)
        }


    }
}