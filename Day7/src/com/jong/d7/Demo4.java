package com.jong.d7;

class GenericDemo<T>{

    T obj;

    void add(T obj){
        this.obj=obj;
    }

    T get(){
        return obj;
    }
}

public class Demo4 {
    public static void main(String[] args) {
        GenericDemo<Integer> gd = new GenericDemo<>();
        gd.add(77);
        System.out.println(gd.get());
    }
}
