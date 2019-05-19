package com.rdf.development.domain.useCase.base

import io.reactivex.Single


abstract class SingleUseCase<T>: BaseUseCase() {

    protected abstract fun build(): Single<T>

    protected fun make(wrap: Boolean): Single<T> {
        val single = wrapDebug(build())
        return if (wrap) wrap(single) else single
    }

    fun get(): Single<T> {
        return make(true)
    }

    fun chain(): Single<T> {
        return make(false)
    }

    protected fun wrap(single: Single<T>): Single<T> {
        return single.compose(schedulerTransformer().applySingleSchedulers())
    }

    private fun wrapDebug(single: Single<T>): Single<T> {
        return single
    }

}