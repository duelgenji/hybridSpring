package com.duelgenji.Java;

import java.util.List;

public class Generic {

    public void func1(List<?> list){

    }


    public <T> void func2(List<T> list){

        list.clear();
    }

    public static void main(String[] args) {


    }
}
