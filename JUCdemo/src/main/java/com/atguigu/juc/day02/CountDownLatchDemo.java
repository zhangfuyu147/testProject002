package com.atguigu.juc.day02;

import com.atguigu.juc.day02.emuns.CountDoenLatchEnum;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 1; i <=5 ; i++) {
            new Thread(()->{
                System.out.println("你完成了" + Thread.currentThread().getName());
                countDownLatch.countDown();
            }, CountDoenLatchEnum.getEnum(i).getMessige()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "完成了超神");
    }
}
