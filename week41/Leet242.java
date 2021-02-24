package me.algo.week41;

import java.util.Arrays;

/**
 * Created by Bomi on 2021/02/24.
 * 문제 출처 : https://leetcode.com/problems/valid-anagram/
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class Leet242 {

    /* O(N logN) */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }


    /*
    O(N)
    public boolean isAnagram(String s, String t) {
        final int ALPHABET_COUNT = 26;

        int[] sAlphabetCount = new int[ALPHABET_COUNT];
        countAlphabet(s, sAlphabetCount);

        int[] tAlphabetCount = new int[ALPHABET_COUNT];
        countAlphabet(t, tAlphabetCount);

        for (int i = 0; i < ALPHABET_COUNT; i++) {
            if (tAlphabetCount[i] != sAlphabetCount[i]) return false;
        }
        return true;
    }

    private void countAlphabet(String str, int[] count) {
        final int ASCII_CODE_LOWER_CASE_A = 'a';
        for (char ch : str.toCharArray()) {
            count[ch - ASCII_CODE_LOWER_CASE_A]++;
        }
    }
    */
}
