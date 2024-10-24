package com.xuwei.jvm.tuning;

/**
 * @program: study
 * @Date: 2024/10/24 10:39
 * @Author: Mr.Xu
 * @Description:
 */
public class DeadLockTest {

    private static final Object o1 = new Object();
    private static final Object o2 = new Object();
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            synchronized (o1){
                System.out.println(Thread.currentThread().getName()+":获取o1监视器，执行代码逻辑，5秒");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":准备获取o2监视器");
                synchronized (o2){
                    System.out.println(Thread.currentThread().getName()+"获取o2监视器，执行逻辑代码");
                }
            }
        },"t1");

        Thread t2 = new Thread(() -> {
            synchronized (o2){
                System.out.println(Thread.currentThread().getName()+":获取o2监视器，执行代码逻辑，5秒");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":准备获取o1监视器");
                synchronized (o1){
                    System.out.println(Thread.currentThread().getName()+"获取o1监视器，执行逻辑代码");
                }
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
