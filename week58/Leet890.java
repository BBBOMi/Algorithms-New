package me.algo.week58;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2021/06/24.
 * 문제 출처 : https://leetcode.com/problems/find-and-replace-pattern/
 *
 * Time Complexity : O(N * M)
 * Used Algorithm : String
 * Used Data structure : Array, Map(HashMap)
 */

public class Leet890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        return Arrays.stream(words)
                .filter(word -> match(word, pattern))
                .collect(Collectors.toList());
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> wordMap = new HashMap();
        Map<Character, Character> patternMap = new HashMap();

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            wordMap.putIfAbsent(w, p);
            patternMap.putIfAbsent(p, w);
            if (wordMap.get(w) != p || patternMap.get(p) != w) return false;
        }
        return true;
    }
}
