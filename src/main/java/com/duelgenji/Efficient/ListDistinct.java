package com.duelgenji.Efficient;

import com.duelgenji.Java.basic.Job;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ListDistinct {


    public static void main(String[] args) {

        List<Job> list = new ArrayList<>();


        list.add(new Job("aaa",1));
        list.add(new Job("aaa",1));
        list.add(new Job("bbb",1));
        list.add(new Job("bbb",1));
        list.add(new Job("ccc",1));
        list.add(new Job("aaa",2));
        list.add(new Job("aaa",3));

        Map<Integer, List<Job>> map = list.stream().collect(Collectors.groupingBy(Job::hashCode));



//        map = map.entrySet().stream().filter(a->a.getValue().size()>1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        map.values().stream().filter(a->a.size()>1).collect(Collectors.toList());

        System.out.println(map);

        AtomicInteger c = new AtomicInteger(2);
        list.stream().forEach(x->x.setMoney(c.getAndIncrement()));

        System.out.println(list);


//        for (Object i: map.keySet()) {
//            System.out.println(map.get(i));
//        }


    }
}
