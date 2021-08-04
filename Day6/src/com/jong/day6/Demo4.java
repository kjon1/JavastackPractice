package com.jong.day6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student implements Comparable<Student>{
    int rollNumber;
    String name;
    int age;
    public Student(int rollNumber, String name, int age) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" + "rollNumber=" + rollNumber + ", name='" + name + '\'' +
                ", age=" + age + '}';
    }

    @Override
    public int compareTo(Student o) {
        if(rollNumber > o.rollNumber)
            return 1;
        else if(rollNumber < o.rollNumber)
            return -1;
        else
            return 0;
    }
    static class SortByAge implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            if(s1.age > s2.age)
                return 1;
            else if(s1.age < s2.age)
                return -1;
            else
                return 0;
        }
    }

    class SortByName implements Comparator<Student> {

        @Override
        public int compare(Student s1, Student s2) {
            return  s1.name.compareTo(s2.name);
        }

    }


    public static class Demo4 {
        public static void main(String[] args) {
            ArrayList<Student> students = new ArrayList<>();
            students.add(new Student(32,"Boomboom", 69));
            students.add(new Student(11,"Digglewiggle", 9));
            students.add(new Student(23,"Flipper", 1));

            System.out.println("before sort..");
            for (Student student: students){
                System.out.println(student);
            }

            Collections.sort(students, new SortByAge());
            System.out.println("after sort");
            for (Student student: students) {
                System.out.println(student);
            }
        }
    }

}
