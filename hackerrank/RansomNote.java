package me.algo.hackerrank;

import java.util.*;

/**
 * Created by Bomi on 2020/10/04.
 * 문제 출처 : https://www.hackerrank.com/challenges/ctci-ransom-note/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : Map(HashMap), Array
 */

public class RansomNote {
    static String checkMagazine(String[] magazine, String[] note) {
        final String IS_FORMED_MAGAZINE = "Yes";
        final String IS_NOT_FORMED_MAGAZINE = "No";

        Map<String, Integer> words = new HashMap<>();
        Arrays.stream(magazine).forEach(m -> words.put(m, words.getOrDefault(m, 0) + 1));
        for (String word : note) {
            int value = words.getOrDefault(word, 0);
            if(value == 0) return IS_NOT_FORMED_MAGAZINE;

            if (--value == 0) words.remove(word);
            else words.put(word, value);
        }
        return IS_FORMED_MAGAZINE;
    }
}
