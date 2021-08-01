package com.jong;

class Student{
    private int id;
    private String name;
    private int passMark = 40;

    public Student(int id) throws Exception{
        if(id < 0)
            throw new Exception("ID CANNOT BE NEGATIVE STUPID");
        this.id = id;

    }
}

public class Demo18 {
    public static void main(String[] args) throws Exception {
        Student student = new Student(-4);
    }

}
