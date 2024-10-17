package com.example.dailylearning.test;

import com.example.dailylearning.bean.UserInfo;

public class RunnableTest extends UserInfo implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable run...");
    }

    public static void main(String[] args) {
        //启动RunnableTest，需要首先实例化一个Thread，并传入自己的RunnableTest实例：
        RunnableTest runnableTest = new RunnableTest();
        Thread thread = new Thread(runnableTest);
        thread.start();

        //事实上，当传入一个 Runnable target 参数给 Thread 后，Thread 的 run()方法就会调用target.run()
        //public void run() {
        //    if (target != null) {
        //        target.run();
        //    }
        //}
    }
}
