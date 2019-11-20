package com.duelgenji.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class Q14_Longest_Common_Prefix {

    public static String longestCommonPrefix(String[] strs){
        if(strs.length<1) return "";
        if(strs.length==1) return strs[0];

        List<char[]> list = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;

        for(String s : strs){

            if(minLength > s.length()){
                minLength = s.length();
            }
            list.add(s.toCharArray());
        }

        StringBuilder prefix = new StringBuilder();

        for(int i =0; i<minLength;i++){

            char first = list.get(0)[i];
            for(int j = 1;j<list.size();j++){

                if(first!=list.get(j)[i]){
                    return prefix.toString();
                }
            }
            prefix.append(first);
        }

        return prefix.toString();
    }

    //solution 1 垂直查找
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    //solution 2 水平查找
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

}
