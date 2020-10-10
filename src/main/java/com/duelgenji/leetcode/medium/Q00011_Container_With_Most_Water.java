package com.duelgenji.leetcode.medium;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class Q00011_Container_With_Most_Water {

    /**
     * 标准做法
     * 循环遍历 效率很慢
     */
    public int maxArea(int[] height) {
        int result = 0;
        int times = 0,smaller;

        for (int i = 0; i < height.length; i++) {
            if( (height[i] * (height.length-1-i)) < result){
                continue;
            }
            for (int j = height.length-1; j > i; j--) {
                if(height[i]>height[j]){
                    smaller = height[j];
                }else{
                    smaller = height[i];
                }


                times = smaller * (j-i);

                if(times > result){

                    result = times;
                }
            }
        }

        return result;
    }


    public int maxArea1(int[] height) {

        int result = 0;
        int times,smaller;
        int bestEnd = height.length-1;

        for (int i = 0; i <= bestEnd; i++) {
            if( (height[i] * (height.length-1-i)) < result){
                continue;
            }
            for (int j = bestEnd; j > i; j--) {

                if(height[i]>height[j]){
                    smaller = height[j];
                }else{
                    smaller = height[i];
                }

                times = smaller * (j-i);

                if(times > result){
                    result = times;
                    bestEnd = j;
                }
            }
        }

        return result;
    }

    /**
     * 结合线上题解
     * 思路：双指针，向内移动短板，（不会错过最优解，有人证明）
     */
    public int maxArea2(int[] height) {
        int result = 0;
        int leftIndex = 0;
        int rightIndex = height.length-1;
        int times;
        while(leftIndex!=rightIndex){

            if(height[leftIndex]>height[rightIndex]){
                times = height[rightIndex] * (rightIndex-leftIndex);
                rightIndex--;
            }else{
                times = height[leftIndex] * (rightIndex-leftIndex);
                leftIndex++;
            }


            if(times > result){
                result = times;
            }

        }

        return result;

    }



    public static void main(String[] args) {
        Q00011_Container_With_Most_Water clz = new Q00011_Container_With_Most_Water();

//        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {1,2,1};
//        int[] height = {1,3,2,5,25,24,5};
//        int[] height = {10,9,8,7,6,5,4,3,2,1};
//        int[] height = {10,14,10,4,10,2,6,1,6,12};
        int[] height = {8,25,7};


        System.out.println(clz.maxArea2(height));

    }
}
