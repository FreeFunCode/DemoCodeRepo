package com.ffc.mf;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import kotlin.jvm.internal.Intrinsics;

public class TestJava {


    public String retrunStr(String str) {
        return str;
    }


    public String str1;
    public static final String str2 = "HelloWorld";


    public String retrunStr2(String str) {
        if (str != null) {
            return str1;
        } else {
            return "";
        }
    }

    public void toLowerStr(String str) {
        try {
            str.toLowerCase();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    public void test() {
        List<String> arr = Arrays.asList("java", "kotlin");
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(i);
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }

        for (Iterator it = arr.iterator(); it.hasNext(); ) {
            System.out.println(it);
        }
    }


    public void test1() {
        int item = 3;
        switch (item) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println(0);
        }
    }

//    public static final void main(@NotNull String[] args) {
//        Intrinsics.checkParameterIsNotNull(args, "args");
//        String var2 = "testLet";
//        System.out.println(var2.length());
//        int result = 1000;
//        System.out.println(result);
//    }


//    public final void main(@NotNull String[] args) {
//        Intrinsics.checkParameterIsNotNull(args, "args");
//        User user = new User("Kotlin", 1, "1111111");
//        String var4 = "my name is " + user.getName() + ", I am " + user.getAge() + " years old, my phone number is " + user.getPhoneNum();
//        System.out.println(var4);
//        int result = 1000;
//        String var3 = "result: " + result;
//        System.out.println(var3);
//    }


//    public final void main(@NotNull String[] args) {
//        Intrinsics.checkParameterIsNotNull(args, "args");
//        User user = new User("Kotlin", 1, "1111111");
//        System.out.println("my name is " + user.getName() + ", I am " + user.getAge() + " years old, my phone number is " + user.getPhoneNum());
//        //输出 my name is Kotlin, I am 1 years old, my phone number is 1111111
//        int result = 1000;
//        System.out.println("result: " + result);//输出 1000
//    }

    public final void main(String[] args) {
        User user = new User("Kotlin", 1, "1111111");
        String var5 = "my name is " + user.getName() + ", I am " + user.getAge() + " years old, my phone number is " + user.getPhoneNum();
        System.out.println(var5);
        String var3 = "result: " + user;
        System.out.println(var3);
    }

    private class User {
        String name;
        Integer age;
        String phoneNum;

        public User(String name, int age, String phoneNum) {
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public String getPhoneNum() {
            return phoneNum;
        }

    }

//    public void main(String[] args) {
//        String var1 = "test";
//        System.out.println(var1.length());
//        String var2 = "1000";
//        System.out.println(var2);
//    }

}






