package com.duelgenji.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 奇数单元格的数目
 * https://leetcode-cn.com/problems/cells-with-odd-values-in-a-matrix/
 */
public class Q01252_Cells_with_odd_values_in_a_matrix {

    public static int oddCells(int n, int m, int[][] indices) {

        int result;

        List<Integer> nList = new ArrayList<>();
        int oddRow = 0;
        int oddCol = 0;

        List<Integer> mList = new ArrayList<>();

        /**
         * 2019-11-11
         * 思路：先计算横向再计算纵向，先记录所有横向的oddRow，只有个位数才会置为奇数，如果重复的会再次成为偶数，
         * 用oddRow * m 就是所有横向的奇数个数
         * oddCol * (n-oddRow) 把刚才横向计算完 还是偶数的统计起来，用纵向总数相乘，
         * oddCol * oddRow 最后减去计算相交（重复部分）
         */
        for (int[] index : indices) {

            if(!nList.contains(index[0])){
                oddRow+=1;
                nList.add(index[0]);
            }else{
                nList.remove(new Integer(index[0]));
                oddRow-=1;
            }

            if(!mList.contains(index[1])){
                oddCol+=1;
                mList.add(index[1]);
            }else{
                oddCol-=1;
                mList.remove(new Integer(index[1]));
            }
        }

        result = oddRow * m + oddCol*(n-oddRow)  - oddCol * oddRow;


        return result;
    }

    public static void main(String[] args) {

        int n = 48;
        int m = 37;
        int[][] indices = {{40,5}};

        System.out.println(oddCells(n,m,indices));

    }


}
