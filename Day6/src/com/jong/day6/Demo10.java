package com.jong.day6;

interface Hello{
    String greeting();
    
}
interface Welcome{
    String greeting(String name);
}
interface Calculation {
    public int addNumber(int a, int b);

}

    //boolean multiplyNumber(int i, int i1);

interface Say{
    public void sayHello(String name);
}

public class Demo10 {
    public static void main(String[] args) {
        Hello hello =() ->{
            return "welcome ";
            
        };
        System.out.println(hello.greeting());
        
        Welcome welcome = (name) -> "welcome" + name;
        Calculation calculation = (a, b) -> {
            return a + b;
        };
        System.out.println(calculation.multiplyNumber(4, 12));
                
    }
}
