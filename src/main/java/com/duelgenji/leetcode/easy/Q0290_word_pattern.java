package com.duelgenji.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/word-pattern/
 * 290. 单词规律
 */
public class Q0290_word_pattern {


    public boolean wordPattern(String pattern, String s) {

        //储存 某pattern字母所代表的单词，初始化都为""
        List<String> patternList = new ArrayList<>(Collections.nCopies(26, ""));

        //pattern 转为char数组
        char[] patternArray = pattern.toCharArray();

        //单词 用空格分割 转为 单词数组
        String[] words = s.split(" ");

        //如果单词和模版长度不同 直接返回false
        if(patternArray.length != words.length) return false;

        for (int i = 0; i< words.length; i++) {
            //从头开始逐个判断，如果只要1个不符合规则，就返回false，不做多余判断
            if(patternList.get(patternArray[i]-97).equals("") && !patternList.contains(words[i])){
                //如果该pattern暂时不代表任何单词，则为他赋值
                patternList.set(patternArray[i]-97, words[i]);
            }else if(!patternList.get(patternArray[i]-97).equals(words[i])){
                //如果该字母已经代表了其他单词，证明不符合规则
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println(new Q0290_word_pattern().wordPattern("aaa","aa aa aa aa"));

    }
}
