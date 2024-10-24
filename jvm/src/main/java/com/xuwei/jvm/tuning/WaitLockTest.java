package com.xuwei.jvm.tuning;

/**
 * @program: study
 * @Date: 2024/10/24 11:04
 * @Author: Mr.Xu
 * @Description:
 */
public class WaitLockTest {

    private static final Object o1 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：准备获取o1");
            syncMethod();
        },"t1");

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：准备获取o1");
            syncMethod();
        },"t2");

        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：准备获取o1");
            syncMethod();
            return;
        },"t3");

        t1.start();
        t2.start();
        t3.start();
    }

    private static void syncMethod() {
        synchronized (o1) {
            System.out.println(Thread.currentThread().getName() + "：获取到o1");
            while (true) {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }
}
