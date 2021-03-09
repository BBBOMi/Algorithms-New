package me.algo.week43;

import java.util.List;

/**
 * Created by Bomi on 2021/03/09.
 * 문제 출처 : https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 *
 * Time Complexity : O(s.length() * dictionary.size())
 * Used Algorithm : Sort
 * Used Data structure : List
 */

public class Leet524 {
    private static final String NO_POSSIBLE_RESULT = "";

    public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : s2.length() - s1.length());

        for (String word : dictionary) {
            int index = 0;
            for (char ch : s.toCharArray()) {
                if (word.charAt(index) == ch) index++;

                if (index == word.length()) return word;
            }
        }
        return NO_POSSIBLE_RESULT;
    }
}
