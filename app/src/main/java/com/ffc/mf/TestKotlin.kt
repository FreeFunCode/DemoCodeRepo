package com.ffc.mf

import java.util.*

class TestKotlin {

    var str1: String? = null
    val str2 = "HelloWorld"


    fun returnStr(str: String): String {
        return str
    }


    fun retrunStr2(str: String?): String {
        return str ?: ""
    }

    fun formatInt(str: String) {
        Integer.parseInt(str)
    }

    fun formatInt2(str: String?) {
        print(str!!)
    }


    fun toLowerStr(str: String) {
        str!!.toLowerCase()
    }

    fun test() {
        val arr = Arrays.asList("java", "kotlin")
        for (i in arr.indices) {
            println(i)
        }

        for (i in arr.indices) {
            println(arr[i])
        }

        val it = arr.iterator()
        while (it.hasNext()) {
            println(it)
        }

        for (item in arr) {
            println(item)
        }
    }


    fun test1() {
        val item = 3
        when (item) {
            1 -> println(1)
            2 -> println(2)
            3 -> println(3)
            else -> println(0)
        }
    }


//    fun main(args: Array<String>) {
//        val result = "testLet".let {
//            println(it.length)
//            //在函数块内可以通过 it 指代该对象。返回值为函数块的最后一行或指定return表达式。
//            1000
//        }
//        println(result)
//    }


//    fun main(args: Array<String>) {
//        val user = User("Kotlin", 3, "1111111")
//
//        val result = with(user) {
//            println("my name is $this.name, I am $age years old, my phone number is $phoneNum")
//            1000
//        }
//        println("result: $result")
//    }


//    fun main(args: Array<String>) {
//        val user = User("Kotlin", 1, "1111111")
//
//        val result = user.run {
//            println("my name is $this.name, I am $age years old, my phone number is $phoneNum")
//            1000
//        }
//        println("result: $result")
//    }

//    fun main(args: Array<String>) {
//        val user = User("Kotlin", 1, "1111111")
//        val result = user.apply {
//            println("my name is $name, I am $age years old, my phone number is $phoneNum")
//            1000
//        }
//        println("result: $result")
//    }
//
//    class User(name: String, age: Int, phoneNum: String) {
//        var name: String
//            get() {
//                return name
//            }
//            set(value) {}
//
//        var age: Int
//            get() {
//                return age
//            }
//            set(value) {}
//
//        var phoneNum: String
//            get() {
//                return phoneNum
//            }
//            set(value) {}
//    }

    fun main(args: Array<String>) {
        val result = "test".also {
            println(it.length)
            1000
        }
        println(result)
    }

}

