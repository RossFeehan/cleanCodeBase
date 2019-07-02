package com.rdf.development.cleancodebase.feature.getCatFact

import com.rdf.development.cleancodebase.base.BaseContract
import com.rdf.development.domain.model.CatFact
import io.reactivex.Single


interface GetCatFactContract: BaseContract {

    interface View: BaseContract.BaseView {

        fun displayCatFact(fact: CatFact)
    }

    interface Presenter: BaseContract.BasePresenter<View>{
    }

    interface Model {

        fun getCatFact(): Single<CatFact>
    }
}