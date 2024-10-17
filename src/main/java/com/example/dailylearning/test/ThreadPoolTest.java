package com.example.dailylearning.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args) {
        // 创建线程池
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        ExecutorService threadPool = new ThreadPoolExecutor(10,50,10, TimeUnit.HOURS,new ArrayBlockingQueue<>(100));


        for (int i = 0; i < 20; i++) {
            int j = i;
            threadPool.execute(new Runnable() { // 提交多个线程任务，并执行
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " is running .." + j);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
