package com.atguigu.juc.day02;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {

   private Map<String,Object> map = new HashMap<>();
   private ReadWriteLock rel = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        rel.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "号 \t 正在写入" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "号 \t 写入完成" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rel.writeLock().unlock();
        }
    }

    public Object get(String key){
        Object result = null;
        rel.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "号 \t 正在读取" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = map.get(key);
            System.out.println(Thread.currentThread().getName() +"号 \t 读取完成" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rel.readLock().unlock();
        }
        return  result;

    }


}


public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache mc = new MyCache();
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(()->{
                mc.put(num+"",num+"");
            },String.valueOf(i)).start();
        }
        for (int i = 1; i <= 5; i++) {
            final int num = i;
            new Thread(()->{
                mc.get(num+"");
            },String.valueOf(i)).start();
        }
    }

}