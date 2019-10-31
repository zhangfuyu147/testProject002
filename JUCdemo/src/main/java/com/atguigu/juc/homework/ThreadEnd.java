package com.atguigu.juc.homework;

class ThreadEnd {

    public static void main(String[] args) {

        ThreadPrelude tp = new ThreadPrelude();


        new Thread(()->{

            for (int i = 1; i <= 26; i++) {
                tp.getNumber();

            }
        },"AA").start();

        new Thread(()->{
            for (int i = 1; i <= 26; i++) {
               tp.getLetter();

            }
        },"BB").start();
    }
}
