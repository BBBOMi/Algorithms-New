package me.algo.week28;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bomi on 2020/11/27.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/68646
 *
 * Time Complexity : O(N)
 * Used Algorithm : Simulation
 * Used Data structure : Set(HashSet)
 */

public class P68646 {
    public int solution(int[] a) {
        Set<Integer> minValues = new HashSet<>();
        final int LENGTH = a.length;

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < LENGTH; i++) {
            min = Math.min(a[i], min);
            minValues.add(min);
        }

        min = Integer.MAX_VALUE;
        for (int i = LENGTH - 1; i >= 0; i--) {
            min = Math.min(min, a[i]);
            minValues.add(min);
        }

        return minValues.size();
    }
}
