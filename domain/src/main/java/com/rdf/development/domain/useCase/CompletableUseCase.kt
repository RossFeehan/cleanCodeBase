package com.rdf.development.domain.useCase

import io.reactivex.Completable


abstract class CompletableUseCase: BaseUseCase() {

    protected abstract fun build(): Completable

    protected fun make(wrap: Boolean): Completable {
        val completable = wrapDebug(build())
        return if (wrap) wrap(completable) else completable
    }

    fun get(): Completable {
        return make(true)
    }

    fun chain(): Completable {
        return make(false)
    }

    protected fun wrap(completable: Completable): Completable {
        return completable.compose(schedulerTransformer().applyCompletableSchedulers())
    }

    private fun wrapDebug(completable: Completable): Completable {
        return completable
    }
}