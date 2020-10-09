package me.algo.leetcode;

/**
 * Created by Bomi on 2020/10/09.
 * 문제 출처 : https://leetcode.com/problems/permutation-in-string/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Sliding-Window
 * Used Data structure : Array
 */

public class Leet567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        final int ALPHABET_COUNT = 26;
        int[] alphabet = new int[ALPHABET_COUNT];
        for (char c : s1.toCharArray()) {
            alphabet[c - 'a']++;
        }

        int left = 0, right = 0;
        int count = s1.length();
        while (right < s2.length()) {
            if (alphabet[s2.charAt(right) - 'a'] > 0) count--;
            alphabet[s2.charAt(right) - 'a']--;
            right++;

            if (count == 0) return true;

            if (right - left < s1.length()) continue;

            if (alphabet[s2.charAt(left) - 'a'] >= 0) count++;
            alphabet[s2.charAt(left) - 'a']++;
            left++;
        }
        return false;
    }
}
