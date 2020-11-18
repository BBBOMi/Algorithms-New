package me.algo.week27;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Bomi on 2020/11/18.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/68644
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Array
 * Used Data structure : Set(TreeSet), Array
 */

public class P68644 {
    public int[] solution(int[] numbers) {
        Set<Integer> sums = new TreeSet<>();

        final int LENGTH = numbers.length;
        for (int i = 0; i < LENGTH; i++) {
            for (int j = i + 1; j < LENGTH; j++) {
                sums.add(numbers[i] + numbers[j]);
            }
        }
        return sums.stream().mapToInt(Integer::intValue).toArray();
    }
}
