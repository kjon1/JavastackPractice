package com.Jong;
class Horse{
    public final int speedLimit = 35;
    public void gallop(){
        //SPEEDLIMIT=7773
        System.out.println("fast horse is galloping at speed of "+ speedLimit);
    }
}

public class Demo11 {
    public static void main(String[] args) {
        Horse horse = new Horse();
        horse.gallop();
    }
}
