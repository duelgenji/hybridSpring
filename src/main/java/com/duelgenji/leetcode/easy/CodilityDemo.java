package com.duelgenji.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodilityDemo {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Set<Integer> set = Arrays.stream(A).boxed().collect(Collectors.toSet());
        return IntStream.rangeClosed(1, A.length).filter(a -> !set.contains(a)).findFirst().getAsInt();

    }

    public static void main(String[] args) {
        CodilityDemo t = new CodilityDemo();


    }
}
