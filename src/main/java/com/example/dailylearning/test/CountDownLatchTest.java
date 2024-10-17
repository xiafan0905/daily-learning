package com.example.dailylearning.test;

public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
//        final int totalThreads = 10;
//        CountDownLatch latch = new CountDownLatch(totalThreads);
//
//        // 创建一个线程池，执行多个任务
//        for (int i = 0; i < totalThreads; i++) {
//            new Thread(() -> {
//               // 模拟任务处理逻辑
//               System.out.println("one task completed.");
//
//               // 任务完成后，计数器减1
//               latch.countDown();
//
//            }).start();
//        }
//
//        // 等待所有任务完成
//        latch.await();
        System.out.println("All tasks completed.");
        int order = 1;
        cs(order);
        System.out.println(order);
    }

    public static void cs(int order){
        cs1(order);

    }

    public static void cs1(int order){
        cs2(order);
    }

    public static void cs2(int order){
        order = order + 10;
    }
}
