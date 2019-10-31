package com.atguigu.juc.day01;


/**
 *1，拷贝小括号
 * 2，写死右箭头
 * 3，落地大括号
 */
@FunctionalInterface
interface  Foo{

    public  int add(int x,int y);

}

public class LambdaDemo {

    public static void main(String[] args) {


        /*Foo foo = new Foo() {
            @Override
            public int add(int x, int y) {
                return x + y;
            }
        };*/



    }
}