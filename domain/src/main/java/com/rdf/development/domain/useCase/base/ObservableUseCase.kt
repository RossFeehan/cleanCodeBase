package com.rdf.development.domain.useCase.base

import io.reactivex.Observable


abstract class ObservableUseCase<T>: BaseUseCase() {

    protected abstract fun build(): Observable<T>

    protected fun make(wrap: Boolean): Observable<T> {
        val observable = wrapDebug(build())
        return if (wrap) wrap(observable) else observable
    }

    fun get(): Observable<T> {
        return make(true)
    }

    fun chain(): Observable<T> {
        return make(false)
    }

    private fun wrap(observable: Observable<T>): Observable<T> {
        return observable.compose(schedulerTransformer().applyObservableSchedulers())
    }

    private fun wrapDebug(observable: Observable<T>): Observable<T> {
        // if (debugTransformer().isPresent && isDebugLogsEnabled()) {
        //    return observable.compose(debugTransformer().get.applyObservableDebugger(getClass().getSimpleName()));
        // }
        return observable
    }

}