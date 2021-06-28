package me.algo;

/**
 * Created by Bomi on 2021/06/28.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12934
 *
 * Time Complexity : O(1)
 * Used Algorithm : Math
 */

public class P12934 {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        if (sqrt == Math.ceil(sqrt))
            return (long) Math.pow(sqrt + 1, 2);
        return -1;
    }
}