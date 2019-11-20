package com.duelgenji.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class Q13_Roman2Integer {



    public static int romanToInt(String s){
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int res = 0;

        char[] cList = s.toCharArray();
        char last = cList[cList.length-1];
        for(int i = cList.length-1 ;i>=0 ; i--){
            if(map.get(last)<=map.get(cList[i])){
                res += map.get(cList[i]);
            }else{
                res -= map.get(cList[i]);
            }
            last = cList[i];
        }
        return res;

    }

    public static void main(String[] args) {

        System.out.println(romanToInt("XXX"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("VI"));
        System.out.println(romanToInt("MCMXCIV"));
    }
}


