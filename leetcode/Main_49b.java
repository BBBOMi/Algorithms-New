package me.algo.leetcode;

import java.util.*;

/**
 * Created by Bomi on 2020/07/24.
 * 문제 출처 : https://leetcode.com/problems/group-anagrams/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hashing
 * Used Data structure : Map(HashMap), List(ArrayList)
 */

public class Main_49b {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> words = new HashMap<>();
        for(String s : strs) {
            String key = getKey(s);
            List<String> value = words.getOrDefault(key, new ArrayList<>());
            value.add(s);
            words.put(key, value);
        }
        return new ArrayList<>(words.values());
    }

    private static String getKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
