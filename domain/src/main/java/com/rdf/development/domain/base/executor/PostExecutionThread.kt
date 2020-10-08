package com.rdf.development.domain.base.executor

import io.reactivex.Scheduler


interface PostExecutionThread {
    fun getScheduler(): Scheduler
}