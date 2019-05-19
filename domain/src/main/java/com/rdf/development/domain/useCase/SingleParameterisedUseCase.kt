package com.rdf.development.domain.useCase

import io.reactivex.Single


abstract class SingleParameterisedUseCase<P, T>: BaseUseCase() {

    protected abstract fun build(params: P): Single<T>

    protected fun make(params: P, wrap: Boolean): Single<T> {
        if (params == null) {
            throw IllegalArgumentException("Parameters must be defined.")
        }
        val single = wrapDebug(build(params))
        return if (wrap) wrap(single) else single
    }

    fun get(params: P): Single<T> {
        return make(params, true)
    }

    fun chain(params: P): Single<T> {
        return make(params, false)
    }

    protected fun wrap(single: Single<T>): Single<T> {
        return single.compose(schedulerTransformer().applySingleSchedulers())
    }

    private fun wrapDebug(single: Single<T>): Single<T> {
        return single
    }


}