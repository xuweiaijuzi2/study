package com.xuwei.juc.test01;

/**
 * @program: study
 * @Date: 2024/10/16 12:56
 * @Author: Mr.Xu
 * @Description:
 */
public class RunnableTest {

    public static void main(String[] args) {

        Thread t  = new Thread(new MyRunnable());
        t.start();
        ThreadLocal<Integer> tl = new ThreadLocal<>();


    }

}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum += i;
            System.out.println(sum);
        }
    }
}