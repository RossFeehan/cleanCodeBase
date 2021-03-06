package com.rdf.development.cleancodebase.base

import com.rdf.development.domain.base.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject


class UIThread @Inject constructor(): PostExecutionThread {

    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()   
    }
}