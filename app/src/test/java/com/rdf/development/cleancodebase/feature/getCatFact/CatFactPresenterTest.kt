package com.rdf.development.cleancodebase.feature.getCatFact

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.rdf.development.domain.model.CatFact
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

    private val catFact = CatFact("id", "fact")

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
        verify(view).displayCatFact(catFact)
    }
}