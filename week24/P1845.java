package me.algo.week24;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bomi on 2020/10/30.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/1845
 *
 * Time Complexity : O(N)
 * Used Algorithm : Implementation
 * Used Data structure : Set(HashSet)
 */

public class P1845 {
    public int solution(int[] nums) {
        Set<Integer> types = new HashSet<>();
        for (int n : nums) {
            types.add(n);
        }
        return Math.min(nums.length / 2, types.size());
    }
}
