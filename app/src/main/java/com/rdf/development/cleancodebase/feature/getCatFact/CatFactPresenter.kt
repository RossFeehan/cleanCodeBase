package com.rdf.development.cleancodebase.feature.getCatFact

import android.util.Log
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
                onSuccess = {
                    if(!it.facts.isEmpty()){
                        view?.displayCatFact(it.facts[0])
                    } else {
                        view?.displayErrorMessage(R.string.no_cat_fact_today)
                    }
                },
                onError = { Log.i("CatFactPresenter", "catFactModel.getCatFact() error")}
            ))
    }
}