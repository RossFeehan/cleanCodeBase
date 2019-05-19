package com.rdf.development.domain.useCase

import io.reactivex.Maybe


abstract class MaybeUseCase<T>: BaseUseCase() {
    protected abstract fun build(): Maybe<T>

    protected fun make(wrap: Boolean): Maybe<T> {
        val single = wrapDebug(build())
        return if (wrap) wrap(single) else single
    }

    fun get(): Maybe<T> {
        return make(true)
    }

    fun chain(): Maybe<T> {
        return make(false)
    }

    private fun wrap(maybe: Maybe<T>): Maybe<T> {
        return maybe.compose(schedulerTransformer().applyMaybeSchedulers())
    }

    private fun wrapDebug(single: Maybe<T>): Maybe<T> {
        return single
    }


}