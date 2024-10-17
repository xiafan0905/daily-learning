package com.example.dailylearning.test;

public class ThreadTest extends Thread{

    @Override
    public void run() {
        System.out.println("ThreadTest run...");
    }

    public static void main(String[] args) {
        ThreadTest test = new ThreadTest();
        test.start();
    }
}
