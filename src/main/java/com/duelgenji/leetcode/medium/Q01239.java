package com.duelgenji.leetcode.medium;

import com.duelgenji.Java.basic.Person;
import com.duelgenji.Java.basic.Student;
import org.apache.logging.log4j.util.Strings;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/solution/java-shi-jian-100-nei-cun-100-by-totallyfine/
 *
 */
public class Q01239 {
    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() == 0)
            return 0;

        return maxLengthDFS(arr, 0, 0);
    }

    //此处函数的目的是为了返回串联字符的最大长度
    public int maxLengthDFS(List<String> arr, int start, int bitMask) {
        if (start == arr.size())
            return 0;

        int ans = 0;
        for (int i = start; i < arr.size(); i++) {
            int bit = convertToBit(arr.get(i));
            if (bit == 0 || (bitMask & bit) != 0) continue;
            //一。当前子字符位掩码不为0（为0的话证明子字符里面有重复字符）
            //二。当前子字符位掩码与前面字符的位掩码与运算结果为0（如果结果不为0，那么说明与之前的字符串有重复）
            //满足上述两个条件才进入一下层递归。
            ans = Math.max(ans, maxLengthDFS(arr, i + 1, bitMask | bit) + arr.get(i).length());
        }
        return ans;
    }

    public static int convertToBit(String s){
        int total = 0;
        for (char c: s.toCharArray()) {
            int bit = 1 << c-'a';
            if((bit&total) !=0){
                return 0;
            }else{
                total = total | bit;
            }
        }

        return total;
    }


    public static void main(String[] args) {

        String a = "ab";





        System.out.println(Integer.toBinaryString(convertToBit(a)));

    }
}
