package com.rdf.development.domain.useCase.base

import com.rdf.development.domain.base.transformer.SchedulerTransformer
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


abstract class BaseUseCase {

    private lateinit var schedulerTransformer: SchedulerTransformer
    private lateinit var debugTransformer: SchedulerTransformer

    @Inject
    fun setSchedulerTransformer(schedulerTransformer: SchedulerTransformer) {
        this.schedulerTransformer = schedulerTransformer
    }

    @Inject
    fun setDebugTransformer(debugTransformer: SchedulerTransformer) {
        this.debugTransformer = debugTransformer
    }

    fun schedulerTransformer(): SchedulerTransformer {
        return schedulerTransformer
    }

    fun debugTransformer(): SchedulerTransformer {
        return debugTransformer
    }

    fun isDebugLogsEnabled(): Boolean {
        return false
    }

    fun Completable.applySubscribeScheduler(): Completable {
        return schedulerTransformer.applySubscribeScheduler(this)
    }

    fun <T> Observable<T>.applySubscribeScheduler(): Observable<T> {
        return schedulerTransformer.applySubscribeScheduler(this)
    }

    fun <T> Single<T>.applySubscribeScheduler(): Single<T> {
        return schedulerTransformer.applySubscribeScheduler(this)
    }

    fun <T> Maybe<T>.applySubscribeScheduler(): Maybe<T> {
        return schedulerTransformer.applySubscribeScheduler(this)
    }

}