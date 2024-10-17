package com.example.dailylearning.test;

public class Thread2 extends Thread{

    private Object object;

    public Thread2(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            System.out.println("开始唤醒");
            object.notify();
        }
    }
}
