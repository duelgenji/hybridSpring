package com.duelgenji.leetcode.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Q3_Longest_substring {

	// low efficient by self
	public int lengthOfLongestSubstring(String s) {

		if (s == null || s.equals(""))
			return 0;
		char[] org = s.toCharArray();
		Set<Character> set = new HashSet<>();
		int length = 0;
		int ans = 0;

		for (int i = 0; i < org.length; i++) {
			if(set.contains(org[i])){

			}
			set.add(org[i]);
			ans = Math.max(ans, set.size());
		}


		return ans;
	}

	// online solution 1
	public int solution(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Q3_Longest_substring q = new Q3_Longest_substring();
		System.out.println(q.lengthOfLongestSubstring("pwwke"));
	}
}
