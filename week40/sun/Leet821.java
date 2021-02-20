package me.algo.week40.sun;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bomi on 2021/02/20.
 * 문제 출처 : https://leetcode.com/problems/shortest-distance-to-a-character/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Set(HashSet), Array
 */

public class Leet821 {
    public int[] shortestToChar(String s, char c) {
        Set<Integer> indexes = new HashSet<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == c) indexes.add(i);
        }

        int[] distances = new int[size];
        for (int i = 0; i < size; i++) {
            int min = Integer.MAX_VALUE;
            if (indexes.contains(i)) {
                min = 0;
            } else {
                for (int index : indexes) {
                    min = Math.min(min, Math.abs(index - i));
                }
            }
            distances[i] = min;
        }
        return distances;
    }
}
