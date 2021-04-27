package com.duelgenji.leetcode.easy;

/**
 * https://leetcode-cn.com/problems/jewels-and-stones/
 */
public class Q0771_jewels_and_stones {

    //char ascii码 最小字母 A = 65 z = 122，122 - 65 + 1 = 58
    //大写和小写编码中间夹杂了6个符号所以不是52
    public int numJewelsInStones(String jewels, String stones) {

        int[] jewelsArr = new int[58];
        int result = 0;
        for (char c : jewels.toCharArray()) {
            jewelsArr[c-65]++;
        }

        for (char c : stones.toCharArray()) {
            if(jewelsArr[c-65] == 1){
                result += 1;
            }
        }


        return result;

    }


    public static void main(String[] args) {
        Q0771_jewels_and_stones leetCode = new Q0771_jewels_and_stones();

        System.out.println(leetCode.numJewelsInStones("z","ZZ"));
//
//        System.out.println('z'-0);

    }
}
