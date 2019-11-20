package com.duelgenji.leetcode.easy;

import java.util.Arrays;

public class Q1104_Distribute_Candies {

    //English
    //https://leetcode.com/problems/distribute-candies-to-people/submissions/

    //Chinese 中文
    //https://leetcode-cn.com/contest/weekly-contest-143/problems/distribute-candies-to-people/

    /**
     * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
     *
     * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
     *
     * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
     *
     * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
     *
     * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）。
     */


    public static void main(String[] args) {
        System.out.println(Arrays.toString(distributeCandies(7, 4)));


    }

    //other player good answer
    public int[] discuss_distributeCandies(int candies, int num_people) {
        int[] people = new int[num_people];
        for (int give = 0; candies > 0; candies -= give) {
            people[give % num_people] +=  Math.min(candies, ++give);
        }
        return people;
    }



    public static int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];

        int current_candy = 0;
        int remain = candies;
        int current_people = 0;

        while(remain>0){
            current_candy++;

            if(current_candy>remain){
                current_candy = remain;
                remain = 0;
            }else{
                remain -= current_candy;
            }

            result[current_people] += current_candy;

            if(current_people == num_people-1){
                current_people = 0;
            }else{
                current_people++;
            }

        }



        return result;
    }
}
