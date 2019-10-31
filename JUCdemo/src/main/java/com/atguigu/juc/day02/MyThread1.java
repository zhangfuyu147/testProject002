package com.atguigu.juc.day02;

import java.util.concurrent.Callable;

public class MyThread1 implements Runnable{
    @Override
    public void run() {


    }
}

class MyThread2 implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        System.out.println(Thread.currentThread().getName() + "执行了Callable接口");

        return 200;
    }



}
