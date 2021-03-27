package me.algo.week46.sun;

import java.util.Arrays;

/**
 * Created by Bomi on 2021/03/27.
 * 문제 출처 : https://leetcode.com/problems/short-encoding-of-words/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class Leet820 {
    public int minimumLengthEncoding(String[] words) {
        return Arrays.stream(words)
                .sorted((word1, word2) -> word2.length() - word1.length())
                .map(it -> it + "#")
                .reduce(this::concat)
                .get().length();
    }

    private String concat(String str, String word) {
        if (canAdd(str, word)) return str + word;
        return str;
    }

    private boolean canAdd(String str, String word) {
        return !str.contains(word);
    }
}
