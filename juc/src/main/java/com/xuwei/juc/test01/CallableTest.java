package com.xuwei.juc.test01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program：study
 * @Date: 2024/10/16 11:14
 * @Author: Mr.Xu
 * @Description: Callable方式创建线程
 */
public class CallableTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        MyCallable ca = new MyCallable();
        FutureTask<Integer> fu = new FutureTask<>(ca);
        Thread t = new Thread(fu);
        System.out.println("main线程中启动t线程");
        t.start();

//        t.interrupt();

//        Integer integer = fu.get();
//        System.out.println("累加和为："+integer);
        System.out.println("main线程睡眠10秒");
        Thread.sleep(10);
        System.out.println("mian线程调用interrupt();");
        System.out.println("main线程执行结束");

    }


}

class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("t线程执行了，睡眠10秒");
        Thread.sleep(10000);
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum+=i;
            System.out.println("t->i：" + i);
            Thread.sleep(1000);
        }
        System.out.println("t线程完成累加任务，准备返回值");
        return sum;
    }
}
