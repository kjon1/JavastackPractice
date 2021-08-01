package com.jong;

class Car{
    public String name;
    public String color;
    public int price;
    public String engine;

    public Car(String name, String color, int price, String engine) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.engine = engine;
    }
    public Car(Car carObj){
        this.name = carObj.name;
        this.color = carObj.color;
        this.price = carObj.price;
        this.engine = carObj.engine;

    }
    public Car(Car carObj, int price){
        this.name = carObj.name;
        this.color =carObj.color;
        this.price = price;
        this.engine = carObj.engine;
    }
}


public class Demo21 {
    public static void main(String[] args) {
        Car c1 = new Car("Audi", "White", 38000, "V8");
        Car c2 = new Car(c1);
        Car c3 = new Car(c1,29000);

    }
}
