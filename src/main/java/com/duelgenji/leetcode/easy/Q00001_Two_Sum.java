package com.duelgenji.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/submissions/
 */
public class Q00001_Two_Sum {


    /**
     * 2019-11-21
     * 基础做法 双层遍历 效率一般
     *
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i <= nums.length-1; i++) {
            for (int j = i+1; j <= nums.length-1; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[2];
    }

    /**
     * 思路
     * 保留差值做法
     * 由于上面遍历了2次，每次计算的差都浪费了，只是用来比较是否等于target
     * 把差值存在Map中，value，储存下标，以后只要判断新的值是否在map中出现即可
     */
    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            Integer lastIndex = map.get(target - nums[i]);
            if(lastIndex != null) {
                return new int[]{lastIndex, i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    /**
     * leetcode fastest
     * 思路：
     * 其实这是投机取巧法，理论上max这个值必须大于数组中的最大值
     * 这个方法完全是利用了leetcode的测试用例的有穷性，max是2^n-1，慢慢测试出来的
     * 如果用这个max虽然可以通过leetcode，但是参数设为{50000,59152} 60000 也会输出[0,1],但实际上是错误的
     */
    public int[] twoSumFast(int[] nums, int target) {
        int max = 2047;
        int[] map = new int[2048];
        for(int i = 0; i < nums.length; i++ ){
            int dif = map[(target - nums[i]) & max];
            if (dif != 0){
                return new int[]{dif - 1, i};
            }
            map[(nums[i]) & max] = i + 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Q00001_Two_Sum clz = new Q00001_Two_Sum();

        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(clz.twoSum(nums, target)));

        System.out.println(2047 & 2);

    }
}
