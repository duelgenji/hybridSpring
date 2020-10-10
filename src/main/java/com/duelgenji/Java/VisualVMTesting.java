package com.duelgenji.Java;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class VisualVMTesting {

    public static void main(String[] args) throws InterruptedException {


        int totalCount = 10000000;

        String a;

        List<String> sList = new ArrayList();

        for (int i = 0; i < totalCount; i++) {


            a = RandomStringUtils.random(300000);
//            System.out.println(a);
            sList.add(a);
            Thread.sleep(500);
            System.out.println("size = " + sList.size());

        }


    }
}
