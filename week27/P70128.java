package me.algo.week27;

import java.util.stream.IntStream;

/**
 * Created by Bomi on 2020/11/19.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/70128
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class P70128 {
    public int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
    }
}
