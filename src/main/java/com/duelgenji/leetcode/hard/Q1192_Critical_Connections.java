package com.duelgenji.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1192. Critical Connections in a Network
public class Q1192_Critical_Connections {

    //question : https://leetcode.com/problems/critical-connections-in-a-network/
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        int count[] = new int[n];

        for (List<Integer> connection : connections) {
            count[connection.get(0)]++;
            count[connection.get(1)]++;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println("number " +i + " appear times:"+count[i]);
        }

        return null;
    }


    public static void removeOneConnection(List<List<Integer>> list, int[] count){
        for (int i : count) {

//            if()

        }

    }


    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(0,1));
        list.add(Arrays.asList(0,2));
        list.add(Arrays.asList(1,2));
        list.add(Arrays.asList(1,3));
        list.add(Arrays.asList(2,3));
        list.add(Arrays.asList(3,4));
        list.add(Arrays.asList(4,5));

        criticalConnections(6,list);
    }


}
