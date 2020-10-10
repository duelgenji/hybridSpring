package com.duelgenji.leetcode.easy;

import java.util.Arrays;

/**
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 *
 * 注意： x 不必 是 nums 的中的元素。
 *
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/special-array-with-x-elements-greater-than-or-equal-x
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q01608 {

    /**
     * 自解方式 先排序，后循环便利
     * @param nums
     * @return
     */
    public int specialArray(int[] nums) {

        int result = -1;

        int length = nums.length;
        Arrays.sort(nums);

        a: for (int i = length; i > 0 ; i--) {


            int temp = 0;

            for (int j = length-1; j >= 0; j--) {
                if(nums[j] < i){
                    if(temp==i){
                        return i;
                    }else{
                        continue a;
                    }
                }
                temp++;
            }

            if(temp==i){
                return i;
            }
        }
        return result;
    }


    /**
     * 参考方式，先排序，后单循环
     * 相通的例子
     * {5,7,8,9,10}
     * {4,7,8,9,10}  （为什么 if条件的有右边判断原因)
     */
    public int specialArray2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        if(n <= nums[0]){
            return n;
        }

        for(int i=1;i<nums.length;i++){
            if(n-i<=nums[i] && n-i>nums[i-1]){
                return n-i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q01608 question = new Q01608();

        int[] array = {0,0,1,3,5};

        int a= question.specialArray(array);

        System.out.println(a);
    }
}
