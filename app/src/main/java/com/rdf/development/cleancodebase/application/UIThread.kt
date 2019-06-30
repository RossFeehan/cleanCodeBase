package com.rdf.development.cleancodebase.application

import com.rdf.development.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject


class UIThread @Inject constructor(): PostExecutionThread {

    override fun getScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()   
    }
}