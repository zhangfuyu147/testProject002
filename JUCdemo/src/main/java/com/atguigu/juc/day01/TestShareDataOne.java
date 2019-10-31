package com.atguigu.juc.day01;

public class TestShareDataOne {

    /**
     * 现在两个线程，
     * 可以操作初始值为零的一个变量，
     * 实现一个线程对该变量加1，一个线程对该变量减1，
     * 交替，来10轮。
     * @param args
     */
    public static void main(String[] args) {

        ShareDataOne sdo = new ShareDataOne();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    sdo.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    sdo.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    sdo.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    sdo.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    sdo.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"EE").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    sdo.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"FF").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    sdo.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"GG").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    sdo.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"HH").start();

    }
}
