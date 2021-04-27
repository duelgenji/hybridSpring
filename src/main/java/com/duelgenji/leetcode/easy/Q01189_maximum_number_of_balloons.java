package com.duelgenji.leetcode.easy;

public class Q01189_maximum_number_of_balloons {

    public int maxNumberOfBalloons(String text) {

        int acsii[] = new int[26];
        for (char c: text.toCharArray()) {
            acsii[c-97]++;
        }

        int result = acsii[0]; //a
        result = Math.min(result, acsii[1]); //b
        result = Math.min(result, acsii[11]/2); //ll
        result = Math.min(result, acsii[14]/2); //oo
        result = Math.min(result, acsii[13]); //n

        return result;

    }

    public static void main(String[] args) {

        System.out.println('a'-97);
        System.out.println('b'-97);
        System.out.println('l'-97);
        System.out.println('o'-97);
        System.out.println('n'-97);
    }
}
