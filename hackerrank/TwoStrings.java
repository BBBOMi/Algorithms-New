package me.algo.hackerrank;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bomi on 2020/10/04.
 * 문제 출처 : https://www.hackerrank.com/challenges/two-strings/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : Set(HashSet), Array
 */

public class TwoStrings {
    static String twoStrings(String s1, String s2) {
        final String IS_CONTAINS = "YES";
        final String IS_NOT_CONTAINS = "NO";
        Set<Character> set = new HashSet<>();
        for(char c : s1.toCharArray()) {
            set.add(c);
        }
        for(char c : s2.toCharArray())  {
            if(set.contains(c)) return IS_CONTAINS;
        }
        return IS_NOT_CONTAINS;
    }
}
