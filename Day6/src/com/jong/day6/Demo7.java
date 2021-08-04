package com.jong.day6;


class Engine{

}
class Tire{

}
class Car{

    Engine engine;
    Tire tire;

    public Car(Engine engine, Tire tire) {
        this.engine = engine;
        this.tire = tire;
    }
}
class CarFactory2{
    public  static void getInstance(int id){
        switch (id){
            case 0:
                System.out.println("");
                break;
            case 1:
                System.out.println("");
                break;
        }
    }
}

public class Demo7 {
}
