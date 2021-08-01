package com.jong.day5;

class MultiThreadDemo2 implements Runnable{
    @Override
    public void run() {
        System.out.println("thread is running");

    }
}

public class Demo2 {
    public static void main(String[] args) {
        MultiThreadDemo2 td2 = new MultiThreadDemo2();
        Thread t1 = new Thread(td2);
        t1.start();
    }
}
