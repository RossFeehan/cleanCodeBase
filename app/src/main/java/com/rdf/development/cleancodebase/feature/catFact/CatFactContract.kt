package com.rdf.development.cleancodebase.feature.catFact

import com.rdf.development.cleancodebase.base.BaseContract
import com.rdf.development.domain.models.CatFact


interface CatFactContract: BaseContract {

    interface View: BaseContract.BaseView {

        fun displayCatFact(fact: CatFact)
    }

    interface Presenter: BaseContract.BasePresenter<View>{
    }
}