package com.jong.day5;

class Table2{
    public void printTable(int number){
        //synchronized block
        synchronized (this){
            for (int i=0; i<10; i++){
                System.out.println(number * i);
                try {
                    Thread.sleep(690);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
class MyThread0 extends Thread{
    Table2 t;
    public MyThread0(Table2 t) {
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(5);
    }
}
class MyThread01 extends Thread{
    Table2 t;
    public MyThread01(Table2 t){
        this.t = t;
    }

    @Override
    public void run() {
        t.printTable(5);
    }
}
public class Demo11 {
    public static void main(String[] args) {
        Table2 t2 = new Table2();
        MyThread0 mt1= new MyThread0(t2);
        MyThread01 mt2= new MyThread01(t2);

        mt1.start();
        mt2.start();

    }

}
