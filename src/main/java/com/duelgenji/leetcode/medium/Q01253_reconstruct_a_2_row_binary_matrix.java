package com.duelgenji.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 重构 2 行二进制矩阵
 * https://leetcode-cn.com/problems/reconstruct-a-2-row-binary-matrix/
 */
public class Q01253_reconstruct_a_2_row_binary_matrix {

    public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {

        /**
         * 2019-11-11
         * 思路 ： 遍历了2次
         * 第一次统计2的次数，如果大于 upper lower 直接返回错误
         * 第二次开始计算，遇到2的两个list都填1，遇到1时，先用upper的填充1，upperRemain用完再用lower
         * 结束之后应该remain都为0，如果不是返回错误
         */

        List<List<Integer>> result = new ArrayList<>();
        int[] upperList = new int[colsum.length];
        int[] lowerList = new int[colsum.length];

        int sum2 = 0;
        for (int i : colsum) {
            if(i==2){
                sum2++;
            }
        }

        int upperRemain = upper-sum2;
        int lowerRemain = lower-sum2;

        if(upperRemain<0 || lowerRemain<0){
            return new ArrayList<>();
        }

        for (int i = 0; i < colsum.length; i++) {

            if(colsum[i]==2){
                upperList[i]=1;
                lowerList[i]=1;
            }else if(colsum[i]==1){
                if(upperRemain>0){
                    upperList[i]=1;
                    upperRemain--;
                }else if(lowerRemain>0){
                    lowerList[i]=1;
                    lowerRemain--;
                }else{
                    return new ArrayList<>();
                }
            }
        }

        if(upperRemain >0 || lowerRemain>0){
            return new ArrayList<>();
        }
        result.add(Arrays.stream(upperList).boxed().collect(Collectors.toList()));
        result.add(Arrays.stream(lowerList).boxed().collect(Collectors.toList()));


        return result;

    }

    public static void main(String[] args) {

        int [] colsum = {2,1,2,0,0,2};
        System.out.println(reconstructMatrix(1,4, colsum));
    }
}
