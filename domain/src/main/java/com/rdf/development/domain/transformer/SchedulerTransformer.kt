package com.rdf.development.domain.transformer

import io.reactivex.*

interface SchedulerTransformer {

    fun <T> applyObservableSchedulers(): ObservableTransformer<T, T>

    fun <T> applySingleSchedulers(): SingleTransformer<T, T>

    fun <T> applyMaybeSchedulers(): MaybeTransformer<T, T>

    fun applyCompletableSchedulers(): CompletableTransformer

    fun <T> applySubscribeScheduler(single: Single<T>): Single<T>

    fun <T> applySubscribeScheduler(maybe: Maybe<T>): Maybe<T>

    fun <T> applySubscribeScheduler(observable: Observable<T>): Observable<T>

    fun applySubscribeScheduler(completable: Completable): Completable
}