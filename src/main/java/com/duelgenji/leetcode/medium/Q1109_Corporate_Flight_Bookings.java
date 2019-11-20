package com.duelgenji.leetcode.medium;

public class Q1109_Corporate_Flight_Bookings {

    //time exceed
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];

        for (int[] booking : bookings) {
            for (int i = booking[0]; i <= booking[1]; i++) {
                result[i-1] += booking[2];
            }
        }

        return result;
    }

    //online discuss

    /**
     * https://leetcode.com/problems/corporate-flight-bookings/discuss/328871/C%2B%2BJava-with-picture-O(n)
     */
    public int[] discuss(int[][] bookings, int n){
        int[] res = new int[n];
        for (int[] v : bookings) {
            res[v[0] - 1] += v[2];
            if (v[1] < n) res[v[1]] -= v[2];
        }
        for (int i = 1; i < n; ++i) res[i] += res[i - 1];
        return res;
    }
}
