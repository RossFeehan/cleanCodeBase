package com.rdf.development.domain.useCase

import io.reactivex.Completable


abstract class CompletableParameterisedUseCase<P>: BaseUseCase() {

    protected abstract fun build(params: P): Completable

    protected fun make(params: P, wrap: Boolean): Completable {
        if (params == null) {
            throw IllegalArgumentException("Parameters must be defined.")
        }
        val completable = wrapDebug(build(params))
        return if (wrap) wrap(completable) else completable
    }

    fun get(params: P): Completable {
        return make(params, true)
    }

    fun chain(params: P): Completable {
        return make(params, false)
    }

    protected fun wrap(completable: Completable): Completable {
        return completable.compose(schedulerTransformer().applyCompletableSchedulers())
    }

    private fun wrapDebug(completable: Completable): Completable {
        return completable
    }

}