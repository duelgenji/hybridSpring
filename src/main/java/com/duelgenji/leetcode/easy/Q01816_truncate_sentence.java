package com.duelgenji.leetcode.easy;

/**
 * https://leetcode-cn.com/problems/truncate-sentence/
 * 1816. 截断句子

 */
public class Q01816_truncate_sentence {

    public String truncateSentence(String s, int k) {

        //将字符串转为char 数组
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i] == ' ' && --k == 0){
                //如果遇到空格，k--， 当k=0时，意味着第k次的空格到了，返回之前的所有字符即可
                return s.substring(0, i);
            }
        }
        //如果k未能减到0，说明后面没更多空格了，直接返回s本身
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Q01816_truncate_sentence().truncateSentence("Hello how are you Contestant", 4));
    }
}
