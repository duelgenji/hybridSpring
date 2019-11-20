package com.duelgenji.Java;

import com.duelgenji.Java.basic.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class StreamDeduplication {


    public static void main(String[] args) {

        Person p;
        List<Person> personList = new ArrayList<>();

        p = new Person();
        p.setName("Knight1");
        p.setAge(30);
        personList.add(p);

        p = new Person();
        p.setName("Knight2");
        p.setAge(30);
        personList.add(p);

        p = new Person();
        p.setName("Knight3");
        p.setAge(20);
        personList.add(p);

        p = new Person();
        p.setName("Knight4");
        p.setAge(25);
        personList.add(p);

        p = new Person();
        p.setName("Knight5");
        p.setAge(20);
        personList.add(p);

        personList = personList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getAge))), ArrayList::new));

        personList.forEach(System.out::println);

    }


}
