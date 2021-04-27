package com.duelgenji.Java.collection;

public class HashTest {

    public static void main(String[] args) {

        StringBuilder str1 = new StringBuilder("a");

        for (int i = 0; i < 100; i++) {
            System.out.println(str1.toString().hashCode());
            str1.append("a");
        }


        // int range -2147483648  ~ 2147483647
        int a = 2147483647;
        System.out.println(++a); //  -2147483648
        System.out.println(--a); //  +2147483647
    }
}
