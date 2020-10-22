package me.algo.week23;

/**
 * Created by Bomi on 2020/10/22.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12985
 *
 * Time Complexity : O(log N)
 * Used Algorithm : recursion
 */

public class P12985 {
    public int solution(int n, int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        return calculate(n, min, max);
    }

    private int calculate(int n, int min, int max) {
        if (min <= n / 2 && n / 2 < max) return (int) (Math.log(n) / Math.log(2));

        if (min > n / 2) {
            min -= n / 2;
            max -= n / 2;
        }
        return calculate(n / 2, min, max);
    }
}
