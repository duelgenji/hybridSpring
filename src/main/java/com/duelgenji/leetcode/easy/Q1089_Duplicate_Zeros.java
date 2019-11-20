package com.duelgenji.leetcode.easy;

import java.util.Arrays;

public class Q1089_Duplicate_Zeros {


    /**
     * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
     *
     * 注意：请不要在超过该数组长度的位置写入元素。
     *
     * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
     *
     */

    public static void duplicateZeros(int[] arr) {

        //基本类型 不能直接用=赋值
        //基本类型 在方法内修改值 在方法外也不会体现
        int[] copy = arr.clone();
        int result_index = 0;

        for (int i : copy) {
            if(i==0){
                arr[result_index] = 0;
                result_index++;

                if(result_index == arr.length){
                    return;
                }else{
                    arr[result_index] = 0;
                    result_index++;

                }

            }else{
                arr[result_index] = i;
                result_index++;

            }

            if(result_index == arr.length){
                return;
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = {0,1,7,6,0,2,0,7};

        System.out.println(Arrays.toString(arr));
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));


    }

    //other player good answer
    public void discuss_duplicateZeros(int[] a) {
        int i = 0, sh = 0;
        for (i = 0; sh + i < a.length; ++i) sh += a[i] == 0 ? 1 : 0;
        for (i = i - 1; sh > 0; --i) {
            if (i + sh < a.length) a[i + sh] = a[i];
            if (a[i] == 0) a[i + --sh] = a[i];
        }
    }


}
