package com.rdf.development.data.executor

import com.rdf.development.domain.base.executor.ThreadExecutor
import java.util.concurrent.*
import javax.inject.Inject


class JobExecutor @Inject constructor(): ThreadExecutor {

    val threadPoolExecutor: ThreadPoolExecutor

    init {
        val workQueue: BlockingQueue<Runnable> = LinkedBlockingQueue()
        this.threadPoolExecutor = ThreadPoolExecutor(
            INITIAL_POOL_SIZE,
            MAX_POOL_SIZE,
            KEEP_ALIVE_TIME.toLong(),
            KEEP_ALIVE_TIME_UNIT,
            workQueue,
            JobThreadFactory()
        )
    }

    override fun execute(runnable: Runnable) {
        this.threadPoolExecutor.execute(runnable)
    }

    class JobThreadFactory : ThreadFactory {
        private var counter = 0

        override fun newThread(runnable: Runnable?): Thread {
            return Thread(runnable, THREAD_NAME + counter++)
        }

        companion object {
            val THREAD_NAME = "android_"
        }
    }

    companion object {

        val INITIAL_POOL_SIZE = 3
        val MAX_POOL_SIZE = 5
        val KEEP_ALIVE_TIME = 10
        val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS
    }
}
