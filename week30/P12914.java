package me.algo.week30;

/**
 * Created by Bomi on 2020/12/10.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12914
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class P12914 {
    private static final int MOD = 1234567;

    public long solution(int n) {
        if (n <= 2) return n;

        long[] steps = new long[n + 1];
        steps[1] = 1;
        steps[2] = 2;
        for (int i = 3; i <= n; i++) {
            steps[i] = (steps[i - 2] + steps[i - 1]) % MOD;
        }
        return steps[n];
    }
}
