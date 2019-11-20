package com.duelgenji.Java;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.util.SerializationUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class JVMTest {
    private static Map<Object, String> map = new WeakHashMap<>();
    private static int count = 1000000;


    public static void main(String[] args) throws InterruptedException {


        printHeader();
        printMemory("init");

        for(int i = 0;i < count;i++){
            map.put(new Object(),"");
        }
        printMemory("put data");

        System.gc();
        printMemory("gc");

        map.clear();

//        Thread.sleep(2000);

        printMemory("map clear");

        System.gc();
        printMemory("gc");
    }



    private static void printHeader(){

        System.out.println("Test " + map.getClass() + ", map size:"+count);

        System.out.println(String.format("%1$-10s","Action") +
                String.format("%1$-16s","Total Mem (KB)") +
                String.format("%1$-16s","Free Mem (KB)") +
                String.format("%1$-15s","Used Mem (KB)") +
                String.format("%1$-15s","KeySet Size") +
                String.format("%1$-15s","EntrySet Size")
        );

    }

    private static void printMemory(String action){
        double totalMemory = Runtime.getRuntime().totalMemory();
        double freeMemory = Runtime.getRuntime().freeMemory();
        double usedMemory = (totalMemory-freeMemory)/1024;
        System.out.println(
                String.format("%1$-10s",action) +
                String.format("%1$-16s",totalMemory/1024) +
                String.format("%1$-16s",freeMemory/1024) +
                String.format("%1$-15s",usedMemory)+
                String.format("%1$-15s",map.keySet().size())+
                String.format("%1$-15s",map.entrySet().size())
        );

    }
}
