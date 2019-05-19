package com.rdf.development.domain.useCase

import io.reactivex.Observable


abstract class ObservableParameterisedUseCase<P, T>: BaseUseCase() {

    protected abstract fun build(params: P): Observable<T>

    protected fun make(params: P, wrap: Boolean): Observable<T> {
        if (params == null) {
            throw IllegalArgumentException("Parameters must be defined.")
        }
        val observable = wrapDebug(build(params))
        return if (wrap) wrap(observable) else observable
    }

    fun get(params: P): Observable<T> {
        return make(params, true)
    }

    fun chain(params: P): Observable<T> {
        return make(params, false)
    }

    protected fun wrap(observable: Observable<T>): Observable<T> {
        return observable.compose(schedulerTransformer().applyObservableSchedulers())
    }

    private fun wrapDebug(observable: Observable<T>): Observable<T> {
        return observable
    }

}