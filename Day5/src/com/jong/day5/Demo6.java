package com.jong.day5;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

class ThreadPriorityDemo extends Thread{
    @Override
    public void run() {
        System.out.println("running thread name is "+ Thread.currentThread().getName());
        System.out.println("running thread priority is "+ Thread.currentThread().getPriority());
    }
}

public class Demo6 {
    public static void main(String[] args) {
        ThreadPriorityDemo t1 = new ThreadPriorityDemo();
        ThreadPriorityDemo t2 = new ThreadPriorityDemo();
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }
}
