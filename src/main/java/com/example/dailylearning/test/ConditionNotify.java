package com.example.dailylearning.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionNotify implements Runnable {

    private Lock lock;

    private Condition condition;

    public ConditionNotify(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            //加锁
            lock.lock();

            System.out.println("begin - notify");
            //唤醒
            condition.signal();
            //间隔2s
            TimeUnit.SECONDS.sleep(2);

            System.out.println("end - notify");

        }catch (Exception e){

        }finally {
            //释放锁
            lock.unlock();
        }
    }

}
