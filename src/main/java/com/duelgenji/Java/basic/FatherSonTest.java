package com.duelgenji.Java.basic;

public class FatherSonTest {

    public static void main(String[] args) {

        Person p = new Person();

        Student s = new Student();

        Person p1 = new Student();

        System.out.println(p.getAge());
        System.out.println(s.getAge());
        System.out.println(p1.getAge());
        System.out.println(((Student)p1).getStudentNumber());

        Person p2 = (Person) s;
        Student s2 = (Student) p;//exception
    }
}
