package com.xuwei.juc.test01;

/**
 * @program: study
 * @Date: 2024/10/10 13:54
 * @Author: Mr.Xu
 * @Description:
 */
public class Demo_01 {

    public static int a = 20000;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                exec();
            }
        },"t1");
        t1.start();
        exec();
    }
    private static void exec() {

        for (int i = 0; i < 10000; i++) {
                a--;
            System.out.println(Thread.currentThread().getName() + "---" + a);
        }
    }
}
