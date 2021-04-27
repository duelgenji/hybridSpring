package com.duelgenji.leetcode.easy;

/**
 * https://leetcode-cn.com/problems/sum-of-unique-elements/
 *
 * 1748. 唯一元素的和
 *
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 *
 * 请你返回 nums 中唯一元素的 和 。
 */
public class Q01748_sum_of_unique_elements {

    public int sumOfUnique(int[] nums) {

        //总和
        int result = 0;

        //由于题目条件有 1<= num <= 100, 最多就100个数字，那么就减个101长度的数组，只多一个0位没事，省的下面数字还要-1。
        int[] array = new int[101];

        for (int num : nums) {
            if(array[num] == 0){
                //初始化的数组默认值都为0，如果为0说明数字没出现过，那么加上该数字，并且把标识位改为"1"（其实随便改为几，方便下一个条件判断）

                result += num;
                array[num] = 1;
            }else if(array[num] == 1){
                //如果标识位改为"1" 说明数字已经出现过，那么要减去该数字，并且把标识位改为"-1"，这样以后再次出现就会忽略

                result -= num;
                array[num] = -1;
            }
        }
        return result;

    }


    public static void main(String[] args) {
        int [] nums = {1,2,3,4};
        System.out.println(new Q01748_sum_of_unique_elements().sumOfUnique(nums));
    }
}
