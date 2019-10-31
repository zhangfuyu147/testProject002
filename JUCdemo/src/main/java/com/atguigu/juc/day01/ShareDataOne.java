package com.atguigu.juc.day01;

public class ShareDataOne {

    private int number = 0;


    public synchronized void increment() throws InterruptedException {

        //判断
        while (number!=0){
            this.wait();
        }
        //干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }

    public synchronized
    void decrement() throws InterruptedException {

        //判断
        while (number!=1){
            this.wait();
        }
        //干活
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //通知
        this.notifyAll();
    }


}
