package com.example.dailylearning.test;

public class Thread1 extends Thread{

    private Object object;

    public Thread1(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        synchronized (object){
            try {
                object.wait();
                System.out.println("开始等待");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
