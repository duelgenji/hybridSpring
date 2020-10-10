package com.duelgenji.leetcode.medium;

import java.util.*;
import java.util.stream.Collectors;

public class Q00015_3sum {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Map<Integer,List<Integer>> minusMap = new HashMap<>();
        Map<Integer,String> readMap = new HashMap<>();
        Map<Integer,String> readKMap = new HashMap<>();

        int count=0;

        for (int i = 0; i < nums.length-2; i++) {

            if(!readMap.containsKey(nums[i])){
                readMap.put(nums[i],"");
            }else{
                continue;
            }

            for (int j = i+1; j < nums.length-1 ; j++) {
                count++;

                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                int minus = -(nums[i]+nums[j]);
                System.out.println(minus);
                if(minusMap.get(minus)!=null){
                    minusMap.get(minus).addAll(list);
                }else{
                    minusMap.put(minus,list);
                }
                System.out.println(minusMap.get(minus));


            }
        }

        for (int k = 2; k < nums.length; k++) {


//            if(readKMap.containsKey(nums[k])){
//                continue;
//            }
//            readKMap.put(nums[k],"");

            List<Integer> minusList = minusMap.get(nums[k]);

            if(minusList!=null && minusList.size()>0){

                for (int index = 0;  index < minusList.size(); index+=2) {
                    count++;
                    if(k!=minusList.get(index) && k!=minusList.get(index+1)){

                        System.out.println("put "+ nums[k]);
                        int[] temp = new int[3];
                        temp[0] = nums[minusList.get(index)];
                        temp[1] = nums[minusList.get(index+1)];
                        temp[2] = nums[k];
                        Arrays.sort(temp);
                        if(!result.contains(Arrays.stream(temp).boxed().collect(Collectors.toList()))){
                            result.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
                        }
//                                result.add(Arrays.asList(minusList.get(index),minusList.get(index+1),nums[k]));
//                                System.out.println(result);

                    }
                }

            }



        }



        System.out.println("count" + count);
        return result;

    }

    public static void main(String[] args) {
        Q00015_3sum clz = new Q00015_3sum();

//        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {3,0,-2,-1,1,2};
//        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
//        int[] nums = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        int[] nums = {0,7,-4,-7,0,14,-6,-4,-12,11,4,9,7,4,-10,8,10,5,4,14,6,0,-9,5,6,6,-11,1,-8,-1,2,-1,13,5,-1,-2,4,9,9,-1,-3,-1,-7,11,10,-2,-4,5,10,-15,-4,-6,-8,2,14,13,-7,11,-9,-8,-13,0,-1,-15,-10,13,-2,1,-1,-15,7,3,-9,7,-1,-14,-10,2,6,8,-6,-12,-13,1,-3,8,-9,-2,4,-2,-3,6,5,11,6,11,10,12,-11,-14};

        System.out.println(nums.length);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(clz.threeSum(nums));




    }
}
