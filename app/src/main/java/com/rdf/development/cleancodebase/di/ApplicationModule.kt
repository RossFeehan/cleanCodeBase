package com.rdf.development.cleancodebase.di

import com.rdf.development.cleancodebase.base.UIThread
import com.rdf.development.data.executor.JobExecutor
import com.rdf.development.domain.base.executor.PostExecutionThread
import com.rdf.development.domain.base.executor.ThreadExecutor
import com.rdf.development.domain.base.transformer.AndroidSchedulerTransformer
import com.rdf.development.domain.base.transformer.SchedulerTransformer
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    @Provides
    fun providesSchedulerTransformer(threadExecutor: ThreadExecutor, postExecutionThread: PostExecutionThread): SchedulerTransformer =
        AndroidSchedulerTransformer(threadExecutor, postExecutionThread)

    @Provides
    fun providesThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor =
            jobExecutor

    @Provides
    fun providesPostExecutionThread(uiThread: UIThread): PostExecutionThread =
            uiThread
}