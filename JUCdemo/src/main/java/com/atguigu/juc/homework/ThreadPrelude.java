package com.atguigu.juc.homework;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程，一个线程打印1-52，另一个打印字母A-Z打印顺序为12A34B...5152Z,
 * 要求用线程间通信
 *
 * 实现思路：
 *  先将打印的内容和顺序写出来
 *  线程A打印两次，然后睡。叫醒线程B
 *  线程B打印一次，然后睡，叫醒线程A
 *  最后将打印结果合并成一条
 *
 */
public class ThreadPrelude {
    private boolean count = true;
    private int num = 1;
    private int letter = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();

    public void getNumber(){
        lock.lock();
        try {
            //1,判断
            while (count != true){
                c1.await();
            }
            //2，干活
            for (int i = 1; i <= 2; i++) {
                System.out.print(num);
                num++;

            }
            //3，通知
            count = false;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void getLetter(){
        lock.lock();
        try {
            //1,判断
            while (count != false){
                c2.await();
            }
            //2，干活

            System.out.print((char) (letter+64));
            letter++;

            //3，通知
            count = true;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int getNum() {
        return num;
    }
}
