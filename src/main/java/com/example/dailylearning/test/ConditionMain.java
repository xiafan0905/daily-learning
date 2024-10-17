package com.example.dailylearning.test;

public class ConditionMain {

    public static void main(String[] args) throws Exception{
//        //创建锁
//        Lock lock = new ReentrantLock();
//        //创建Condition
//        Condition condition = lock.newCondition();
//
//        // 保证两个线程获取的是同一把锁 和 同一个COndition
//
//        new Thread(new ConditionWait(lock, condition)).start();
//
//        new Thread(new ConditionNotify(lock, condition)).start();

        Object object = new Object();
        Thread thread1 = new Thread(new Thread1(object));
        Thread thread2 = new Thread(new Thread2(object));
        thread1.start();
        thread2.start();
    }
}
