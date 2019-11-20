package com.duelgenji.leetcode.easy;

public class Q9_Palindrome_Number {

     //判断是否回流 int
    public boolean isPalindrome(int x){
        String s = x+"";
        char[] c = s.toCharArray();
        for(int i=0;i<=c.length/2;i++){
            if(c[i]!=c[c.length-1-i]){
                return false;
            }
        }
        return true;
    }
}
