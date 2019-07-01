package com.rdf.development.cleancodebase.feature.getCatFact

import com.rdf.development.cleancodebase.base.BaseContract
import com.rdf.development.domain.model.CatFact
import com.rdf.development.domain.model.Fact
import io.reactivex.Single


interface GetCatFactContract: BaseContract {

    interface View: BaseContract.BaseView {

        fun displayCatFact(fact: Fact)
    }

    interface Presenter: BaseContract.BasePresenter<View>{


    }

    interface Model {

        fun getCatFact(): Single<CatFact>
    }
}