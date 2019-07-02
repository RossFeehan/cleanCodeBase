package com.rdf.development.cleancodebase.feature.getCatFact

import com.rdf.development.cleancodebase.R
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject


class CatFactPresenter @Inject constructor(private val catFactModel: CatFactModel): GetCatFactContract.Presenter {

    override var view: GetCatFactContract.View? = null
    override var compositeDisposable: CompositeDisposable? = null

    override fun onTakeView() {
        super.onTakeView()

        compositeDisposable?.add(catFactModel.getCatFact()
            .subscribeBy(
                onSuccess = { view?.displayCatFact(it) },
                onError = { view?.displayErrorMessage(R.string.no_cat_fact_today)}
            ))
    }
}