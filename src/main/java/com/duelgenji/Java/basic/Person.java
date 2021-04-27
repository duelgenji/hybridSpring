package com.duelgenji.Java.basic;

import lombok.Data;

@Data
public class Person {
    private String name;

    private Integer age = 1;

    private Job job;

    public Person() {
        System.out.println(111);
    }
}
