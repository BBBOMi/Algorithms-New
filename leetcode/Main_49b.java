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
            words.getOrDefault(getKey(s), new ArrayList<>()).add(s);
        }
        return new ArrayList<>(words.values());
    }

    private static String getKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}
