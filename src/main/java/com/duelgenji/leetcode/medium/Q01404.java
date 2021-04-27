package com.duelgenji.leetcode.medium;

/**
 * https://leetcode-cn.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
 * 位运算
 * 将二进制表示减到1的步骤数
 */
public class Q01404 {

    public int numSteps(String s) {
        return 1;
    }

    // tesla interview question, if odd subtract 1 from it, if even divide it by 2, until becomes 0
    // this solution or this algorithm
    public int teslaSteps(String s){

        int steps = 0;

        int start_loop_index = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                start_loop_index = i;
                break;
            }
        }

        for (int i = s.length() - 1; i > start_loop_index ; i--) {
            if(s.charAt(i) == '0'){
                steps++;
            }else if(s.charAt(i) == '1'){
                steps+=2;
            }
        }

        return steps + 1;
    }


    public int solution(String S) {

        boolean start = false;
        int res = 0;
        for (char c : S.toCharArray()) {
            if (c == '1') {
                res += start ? 2 : 1;
                start = true;
            } else if (start) {
                res += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 400000; i++) {
            s.append("1");
        }

        Q01404 q = new Q01404();
        System.out.println(q.solution(s.toString()));


    }


}
