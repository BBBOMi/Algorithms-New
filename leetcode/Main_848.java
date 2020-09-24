package me.algo.leetcode;

/**
 * Created by Bomi on 2020/09/24.
 * 문제 출처 : https://leetcode.com/problems/shifting-letters
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class Main_848 {
    public String shiftingLetters(String S, int[] shifts) {
        final int ALPHABET_COUNT = 26;
        int sum = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {
            shifts[i] = (shifts[i] + sum) % ALPHABET_COUNT;
            sum = shifts[i];
        }

        StringBuilder sb = new StringBuilder(S.length());
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            c += shifts[i];
            if (c > 'z') c = (char) (c - ALPHABET_COUNT);
            sb.append(c);
        }

        return sb.toString();
    }
}
