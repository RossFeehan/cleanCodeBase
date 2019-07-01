package com.rdf.development.domain.useCase.feature

import com.rdf.development.domain.model.CatFact
import com.rdf.development.domain.repository.CatFactRepository
import com.rdf.development.domain.useCase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetCatFactUseCase @Inject constructor(val catFactRepository: CatFactRepository): SingleUseCase<CatFact>(){

    override fun build(): Single<CatFact> {
        return catFactRepository.getCatFact()
    }
}