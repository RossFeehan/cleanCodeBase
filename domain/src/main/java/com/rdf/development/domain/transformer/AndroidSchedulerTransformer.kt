package com.rdf.development.domain.transformer

import com.rdf.development.domain.executor.PostExecutionThread
import com.rdf.development.domain.executor.ThreadExecutor
import io.reactivex.*
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class AndroidSchedulerTransformer @Inject
constructor(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread) : SchedulerTransformer {

    private val subscribeScheduler: Scheduler
    private val observeScheduler: Scheduler

    init {
        subscribeScheduler = Schedulers.from(threadExecutor)
        observeScheduler = postExecutionThread.getScheduler()
    }

    override fun <T> applyObservableSchedulers(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
        }
    }

    override fun <T> applySingleSchedulers(): SingleTransformer<T, T> {
        return SingleTransformer { single ->
            single.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
        }
    }

    override fun <T> applyMaybeSchedulers(): MaybeTransformer<T, T> {
        return MaybeTransformer { maybe ->
            maybe.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
        }
    }

    override fun applyCompletableSchedulers(): CompletableTransformer {
        return CompletableTransformer { completable ->
            completable.subscribeOn(subscribeScheduler).observeOn(observeScheduler)
        }
    }

    override fun <T> applySubscribeScheduler(single: Single<T>): Single<T> {
        return single.subscribeOn(subscribeScheduler)
    }

    override fun <T> applySubscribeScheduler(observable: Observable<T>): Observable<T> {
        return observable.subscribeOn(subscribeScheduler)
    }

    override fun applySubscribeScheduler(completable: Completable): Completable {
        return completable.subscribeOn(subscribeScheduler)
    }

    override fun <T> applySubscribeScheduler(maybe: Maybe<T>): Maybe<T> {
        return maybe.subscribeOn(subscribeScheduler)
    }
}
