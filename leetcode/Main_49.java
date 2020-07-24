package me.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2020/07/24.
 * 문제 출처 : https://leetcode.com/problems/group-anagrams/
 *
 * Time Complexity : O(N)
 * Used Algorithm : 해싱
 * Used Data structure : Map(HashMap), List(ArrayList)
 */

public class Main_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> words = new HashMap<>();
        for(String s : strs) {
            String key = Arrays.stream(s.split("")).sorted().collect(Collectors.joining());
            List<String> values;
            if(words.containsKey(key)) {
                values = words.get(key);
            } else {
                values = new ArrayList<>();
            }
            values.add(s);
            words.put(key, values);
        }
        List<List<String>> result = new ArrayList<>();
        for(String key : words.keySet()) {
            result.add(words.get(key));
        }
        return result;
    }
}
