package com.duelgenji.leetcode.easy;

public class Q7_Reverse_Integer {

    public int reverse(int x) {
        int sign = 1;
        if(x<0){
            sign = -1;
            x = x * -1;
        }

        String s = x + "";
        s =  new StringBuilder(s).reverse().toString();

        try{

            return Integer.parseInt(s)*sign;
        }catch(Exception e){
            return 0 ;
        }

    }

    //online solution
    public int solution(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
