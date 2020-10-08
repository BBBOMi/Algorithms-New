package me.algo.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bomi on 2020/10/08.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/68646
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Set(HashSet), Array
 */

public class P68646 {
    public int solution(int[] a) {
        Set<Integer> set = new HashSet<>();
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            set.add(min);
            min = Math.min(min, a[i]);
        }

        min = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            set.add(min);
            min = Math.min(min, a[i]);
        }
        return set.size();
    }
}


