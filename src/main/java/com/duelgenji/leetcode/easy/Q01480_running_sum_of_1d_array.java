package com.duelgenji.leetcode.easy;

public class Q01480_running_sum_of_1d_array {

    public int[] runningSum(int[] nums) {

        int [] result = new int[nums.length];

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            result[i] = sum;

        }

        return result;
    }

    public static void main(String[] args) {

        Q01480_running_sum_of_1d_array f = new Q01480_running_sum_of_1d_array();

        int [] aa = {1,2,3,4};

        int [] r = f.runningSum(aa);
        for (int i : r) {
            System.out.printf(i+",");
        }

    }
}
