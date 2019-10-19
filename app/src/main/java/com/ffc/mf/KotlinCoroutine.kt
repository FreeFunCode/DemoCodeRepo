package com.ffc.mf

import kotlinx.coroutines.*

class KotlinCoroutine {

    fun coroutineDemo1(){
        println("test func coroutineDemo1")
        GlobalScope.launch {
            delay(2000)
            println("coroutine finish")
        }

        println("coroutine start")
        Thread.sleep(3000)
        println("coroutine end")
    }


    @ExperimentalCoroutinesApi
    fun testInnerCoroutines() = runBlocking {
        println("[testInnerCoroutines] start ")
        val request = GlobalScope.launch {
            println("主协程 thread:${Thread.currentThread()}")
            val job1 = GlobalScope.launch {
                println("job1: 独立的协程上下文! thread:${Thread.currentThread()}")
                delay(1000)
                println("job1: 不会受到request.cancel()的影响")
            }
            // 继承父上下文
            val job2 = GlobalScope.launch(Dispatchers.Unconfined) {
                println("job2: 是request coroutine的子协程 thread:${Thread.currentThread()}")
                delay(1000)
                println("job2: 当request.cancel()，job2也会被取消")
            }
            job1.join()
            job2.join()
        }
        delay(500)
        request.cancel()
        delay(1000)
        println("main: Who has survived request cancellation?")
    }

}

