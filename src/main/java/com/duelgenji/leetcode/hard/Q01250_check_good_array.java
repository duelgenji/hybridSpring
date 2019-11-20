package com.duelgenji.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class Q01250_check_good_array {


    static Map<Integer, Boolean> map = new HashMap<>();

    public boolean isGoodArray(int[] nums) {

        if(nums.length==1){
            if(nums[0]==1){
                return true;
            }else{
                return false;
            }
        }
        return DFS(0, nums);

    }

    public boolean DFS(int index, int[] nums){


        if(index < nums.length - 1){

            if(nums[index] > nums[index+1]){


                int mod = nums[index]%nums[index+1];
                int differ = nums[index] - nums[index+1];
                if(mod!=0 && (mod==1 ||  (mod!=differ && ( nums[index]%mod!=0 && nums[index+1]%mod!=0)))){

                    System.out.println(nums[index]);
                    System.out.println(nums[index+1]);
                    System.out.println(mod);

                    return true;
                }else{
                    return DFS(index+1, nums);
                }
            }else{
                int mod = nums[index+1]%nums[index];
                int differ = nums[index+1] - nums[index];

                if(mod!=0 && (mod==1 ||  (mod!=differ && ( nums[index]%mod!=0 && nums[index+1]%mod!=0)))){
                    return true;
                }else{
                    return DFS(index+1, nums);
                }
            }

        }else{
            return false;
        }

    }

    public boolean isPrime(int num){
        boolean isPrime = true;
        if ( num == 1)
        {
            return false;
        }
        for( int i = 2; i< num; i++)
        {
            if(num % i ==0)
            {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Q01250_check_good_array clz = new Q01250_check_good_array();


//        int[] nums = {100,90,70,80,40,75,135,120,150,150,1000};
        int[] nums = {6,10,15};

        System.out.println(clz.isGoodArray(nums));
//
//        System.out.println(2%1);
    }
}
