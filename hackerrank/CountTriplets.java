package me.algo.hackerrank;

import java.util.*;

/**
 * Created by Bomi on 2020/10/05.
 * 문제 출처 : https://www.hackerrank.com/challenges/count-triplets-1/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : Map(HashMap), Array
 */

public class CountTriplets {
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, Long> leftMap = new HashMap<>();
        Map<Long, Long> rightMap = new HashMap<>();
        for (long n : arr) {
            rightMap.put(n, rightMap.getOrDefault(n, 0L) + 1);
        }

        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            long midTerm = arr.get(i);
            rightMap.put(midTerm, rightMap.getOrDefault(midTerm, 0L) - 1);

            long c1 = midTerm % r == 0 ? leftMap.getOrDefault(midTerm / r, 0L) : 0L;
            long c3 = rightMap.getOrDefault(midTerm * r, 0L);

            count += c1 * c3;
            leftMap.put(midTerm, leftMap.getOrDefault(midTerm, 0L) + 1);
        }
        return count;
    }
}
