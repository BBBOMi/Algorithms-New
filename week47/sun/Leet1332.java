package me.algo.week47.sun;

/**
 * Created by Bomi on 2021/03/29.
 * 문제 출처 : https://leetcode.com/problems/remove-palindromic-subsequences/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 */

public class Leet1332 {
    public int removePalindromeSub(String s) {
        final int MAX_COUNT = 2;
        return isPalindromeSub(s) ? 1 : MAX_COUNT;
    }

    private boolean isPalindromeSub(String s) {
        int left = -1, right = s.length();
        while (++left <= --right) {
            if (s.charAt(left) != s.charAt(right)) return false;
        }
        return true;
    }
}
