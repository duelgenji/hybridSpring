package com.duelgenji.Java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class StreamTest {

    public static void main(String[] args) {

        List<String> stringList = new LinkedList<>();
        stringList.add("aaaaa");
        stringList.add("bbbbb");
        stringList.add("ccccc");
        stringList.add("ddddd");
        stringList.add("aaaaa");

        System.out.println(stringList.stream().filter(c-> c.length()<=5).count());
        System.out.println(stringList.stream().findFirst().orElse(""));

        stringList.stream().skip(2).forEach(System.out::println);
        stringList.stream().limit(2).forEach(System.out::println);
        stringList.forEach(System.out::println);

        stringList.stream().distinct().forEach(System.out::println);
        stringList.stream().map(String::length).forEach(System.out::println);
        stringList.stream().map(x->x.split("")).flatMap(Arrays::stream).forEach(System.out::println);

        int len = 5;
        stringList.stream().anyMatch(x->x.length()>len);
        stringList.stream().allMatch(x->x.length()>5);
        stringList.stream().noneMatch(x->x.length()>5);
        

    }
    
}
