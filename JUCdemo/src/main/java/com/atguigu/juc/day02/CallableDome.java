package com.atguigu.juc.day02;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class CallableDome {

    public static void main(String[] args) throws Exception{

//        FutureTask<Integer> futureTask = new FutureTask(new MyThread2());
        FutureTask<Integer> futureTask = new FutureTask(()->{
            System.out.println(Thread.currentThread().getName()+"AAAAAA");
            TimeUnit.SECONDS.sleep(3);
            return 1024;
        });


        System.out.println(1+2+3*8*5_12);

       /* FutureTask<Integer> futureTask2 = new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName() + "BBBBBB");
//            TimeUnit.SECONDS.sleep(2);
            return 2048;
        });*/

        new Thread(futureTask,"李白").start();
//        new Thread(futureTask2,"杜甫").start();

        /*while (!futureTask.isDone()){
            System.out.println("****wait****");

        }*/
        System.out.println(futureTask.get());
        System.out.println(Thread.currentThread().getName() + "game over");
    }
}
