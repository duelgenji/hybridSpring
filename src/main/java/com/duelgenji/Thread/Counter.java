package com.duelgenji.Thread;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {



    public volatile static AtomicInteger i = new AtomicInteger(0);
    public volatile static int j = 0;
    public volatile static Map<String, String> map = new HashMap<>();
    public volatile static List<String> list = new ArrayList<>();

    public static void inc() {

        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        i.getAndAdd(1);
        j++;
        map.put(UUID.randomUUID().toString(),"");
        list.add(UUID.randomUUID().toString());
    }

    public static void main(String[] args) {

        //同时启动1000个线程，去进行i++计算，看看实际结果

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Counter.inc();
                }
            }).start();
        }

        try {
            Thread.sleep(2000);

            //这里每次运行的值都有可能不同,可能为1000
            System.out.println("运行结果:Counter.count="+i);
            System.out.println("运行结果:Counter.count="+j);
            System.out.println("运行结果:map size="+map.size());
            System.out.println("运行结果:list size="+list.size());

        } catch (InterruptedException e) {
        }

    }
}
