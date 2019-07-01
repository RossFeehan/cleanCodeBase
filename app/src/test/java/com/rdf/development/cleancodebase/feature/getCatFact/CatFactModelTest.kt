package com.rdf.development.cleancodebase.feature.getCatFact

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.rdf.development.domain.useCase.feature.GetCatFactUseCase
import org.junit.Test

class CatFactModelTest {

    private val getCatFactUseCase: GetCatFactUseCase = mock()

    private val model = CatFactModel(getCatFactUseCase)

    @Test
    fun when_getCatFactModelCalled_then_callCorrectUseCase(){
        //WHEN
        model.getCatFact()
        //THEN
        verify(getCatFactUseCase).get()
    }
}