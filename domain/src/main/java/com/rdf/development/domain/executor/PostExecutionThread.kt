package com.rdf.development.domain.executor

import io.reactivex.Scheduler


interface PostExecutionThread {
    fun getScheduler(): Scheduler
}