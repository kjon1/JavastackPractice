package com.jong;

interface Drawable{
    void draw();

    default void print(){
        System.out.println("printing");
    }
}
class Rectangle implements Drawable{
    @Override
    public void draw() {

    }


}
public class Demo22 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        rect.draw();
        rect.print();
    }
}
