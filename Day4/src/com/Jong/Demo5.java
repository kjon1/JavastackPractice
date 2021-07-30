package com.Jong;

import java.util.ArrayList;
import java.util.Iterator;

class Student{
    public int id;
    public String name;
    public String grade;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public Student(int id, String name, String grade){
        this.id = id;
        this.name = name;
        this.grade = grade;

    }
}

public class Demo5 {
    public static void main(String[] args) {
        //user define class object
        Student s1 = new Student(1, "Malak", "freshman");
        Student s2 = new Student(2, "Halibut", "junior");
        Student s3 = new Student(3, "Fisher", "senior");

        //create arraylist
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        //foreach
        for (Student student: students){
            System.out.println(student);
        }

    }
}
