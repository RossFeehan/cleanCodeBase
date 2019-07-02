package com.rdf.development.cleancodebase.feature.getCatFact

import com.nhaarman.mockito_kotlin.anyVararg
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.rdf.development.domain.model.CatFact
import com.rdf.development.domain.model.Fact
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import utils.RxSchedulersRule

class CatFactPresenterTest {

    @get:Rule
    var rule = RxSchedulersRule()

    private val catFactModel: CatFactModel = mock()

    private val presenter = CatFactPresenter(catFactModel)

    private val view: GetCatFactContract.View = mock()

    private val fact = Fact("id", "fact")
    private val factList = mutableListOf(fact)
    private val catFact = CatFact(factList)

    private val emptyFactList = mutableListOf<Fact>()
    private val emptyCatFact = CatFact(emptyFactList)

    @Before
    fun setup(){
        whenever(catFactModel.getCatFact()).thenReturn(Single.just(catFact))
    }

    @Test
    fun when_onTakeView_then_getCatFactFromModel(){
        //WHEN
        presenter.takeView(view)
        //THEN
        verify(catFactModel).getCatFact()
    }

    @Test
    fun when_successfullyGetCatFact_then_displayInView(){
        //WHEN
        presenter.takeView(view)
        //THEN
        verify(view).displayCatFact(fact)
    }
}