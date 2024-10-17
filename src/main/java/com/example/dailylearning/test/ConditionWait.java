package com.example.dailylearning.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionWait implements Runnable {

    private Lock lock;

    private Condition condition;

    public ConditionWait(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            //加锁
            lock.lock();

            System.out.println("begin - wait");
            //间隔2s
            TimeUnit.SECONDS.sleep(2);
            //休眠
            condition.await();
            System.out.println("end - wait");

        }catch (InterruptedException e){

        }finally {
            lock.unlock();
        }
    }
}
