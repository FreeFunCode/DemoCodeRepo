package com.ffc.mf

import kotlinx.coroutines.*

@ObsoleteCoroutinesApi
class KotlinCoroutine {

    fun coroutineDemo1() {
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
        val request = GlobalScope.launch() {
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

        /** ---------------------协程----------------------**/

        /**
         * 创建
         */
        //launch
        launch{
                    delay(1000)
                    println("launch")
                }

        //async
        async {
            delay(1000)
            println("async")
            //async 才能有return
            return@async ""
        }


        /**
         * 上下文
         */
        launch { // 运行在父协程的上下文中，即 runBlocking 主协程
            println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) { // 将会获取默认调度器
            println("Default               : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Main) { // Android主线程
            println("Main               : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.IO) { // 共享后台线程池里的线程
            println("IO               : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Unconfined) { // 不受限的——将工作在主线程中
            println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(newSingleThreadContext("MyOwnThread")) { // 将使它获得一个新的线程
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        }



    }

}

