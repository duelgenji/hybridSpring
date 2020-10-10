package com.duelgenji.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class Q01481_least_number_of_unique_int_after_k_removals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i : arr) {
            if(map.get(i)==null){
                map.put(i,1);
                countMap.merge(1, 1, Integer::sum);
            }else{
                map.put(i,map.get(i)+1);
                countMap.merge(map.get(i), 1, Integer::sum);
                countMap.merge(map.get(i)-1, -1, Integer::sum);

            }
        }

        int removeCount = 0;
        for (Integer value : countMap.keySet()) {
            int count = countMap.get(value);
            if(k>=count * value){
                k -= count * value;
                removeCount += count;
            }else if(k/value>=1){
                removeCount += k/value;
                k=0;
            }else{
                k=0;
            }

            if(k==0){
                break;
            }
        }
        return map.size() - removeCount;
    }

    public static void main(String[] args) {

        Q01481_least_number_of_unique_int_after_k_removals f = new Q01481_least_number_of_unique_int_after_k_removals();
        int[] aa = {4,3,1,1,3,3,2};
        int r = f.findLeastNumOfUniqueInts(aa,3);

        System.out.println(r);
    }
}
