package me.algo.week19;

/**
 * Created by Bomi on 2020/09/25.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12914
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class P12914 {
    private static final int MOD = 1234567;
    public long solution(int n) {
        if(n <= 2) return n;

        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % MOD;
        }

        return dp[n];
    }
}
