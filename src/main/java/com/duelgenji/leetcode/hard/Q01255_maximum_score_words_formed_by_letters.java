package com.duelgenji.leetcode.hard;

/**
 * 得分最高的单词集合
 * https://leetcode-cn.com/problems/maximum-score-words-formed-by-letters/
 */
public class Q01255_maximum_score_words_formed_by_letters {

    String[] words;

    int[] wordScore;

    int max = 0;

    /**
     * 2019-11-13 ～ 11-14
     * 思路（结合答案）：
     * 把所有可用的次数[letters]放到26长度的数组中remainArray，因为只有26个字母
     * 计算所有words的得分，放在word 得分数组中，长度为words数组的长度
     * 然后开始 深度优先搜索DFS
     * 先根据当前word的单词拆分成一个个字母，判断是否有足够的字母够他使用，
     * 如果够扣的话
     * 就减去用掉的字母，加上得分继续下一步；并且
     * t:同时加回原来的去掉的字母，不加得分（相当于跳过这个单词，直接去下一个单词，比如原先顺序是1-2-3-4-5，我们要同时走1 -2 -3 -4 -5... 也要走 1 - 3 - 4 -5）
     *
     * 如果不够扣的话，同t
     *
     * ps：t 这一部，在原先做的时候 我用了array的clone,相当于先把 待扣字母数组copy了一份，这样省去了 把去掉字母补回的操作，代码也稍微少一点
     * 但实际上 copy效率更慢，补回因为是直接根据word的单词指定index 一个个 操作数组，更快。
     * copy 用了2ms（defeat 88% 100%） ，for array 补回 用了 1 ms（defeat 100% 100%)
     */
    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        this.words = words;
        this.wordScore = new int[words.length];

        int[] remainArray = new int[26];

        for (char letter : letters) {
            remainArray[letter-'a']++;
        }

        for (int i = 0; i < words.length; i++) {

            int ws = 0;
            for (int j = 0; j < words[i].length(); j++) {
                char charat = words[i].charAt(j);
                ws += score[charat-'a'];
            }
            wordScore[i] = ws;
        }

        DFS(0, 0, remainArray);

        return max;

    }

    public void DFS(int sum,int start, int[] remainArray){


        if(start>=words.length) {
            return;
        }

        boolean enough = true;



//        int [] sourceRemainArray = remainArray.clone();

        for (int j = 0; j < words[start].length(); j++) {
            char charat = words[start].charAt(j);
            remainArray[charat-'a']--;
            if(remainArray[charat-'a'] < 0){
                enough = false;
            }
        }

        if(enough){
            DFS(sum + wordScore[start], start+1, remainArray);
            max = Math.max(max, sum + wordScore[start]);
        }

        for (int j = 0; j < words[start].length(); j++) {
            char charat = words[start].charAt(j);
            remainArray[charat - 'a']++;
        }
        DFS(sum , start+1, remainArray);
    }

    public static void main(String[] args) {
//        String[] words = {"xxxz","ax","bx","cx"};
//        char[] letters = {'z','a','b','c','x','x','x'};
//        int[] score = {4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};

        String[] words = {"da","ac","aba","abcc","cadc"};
        char[] letters = {'a','a','a','a','b','c','c','c','d','d','d'};
        int[] score = {3,7,9,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        Q01255_maximum_score_words_formed_by_letters clz = new Q01255_maximum_score_words_formed_by_letters();

        System.out.println(clz.maxScoreWords(words,letters,score));




    }
}
