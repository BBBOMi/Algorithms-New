package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Bomi on 2021/06/26.
 * 문제 출처 : https://www.acmicpc.net/problem/15988
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class BOJ15988 {
    private static final int MOD = 1_000_000_009;
    private static final int MAX_VALUE = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] inputs = new int[t];

        int max = 0;
        for (int i = 0; i < t; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, inputs[i]);
        }
        long[] dp = new long[MAX_VALUE + 1];
        countTheNumberOfExpressions(max, dp);
        Arrays.stream(inputs).forEach(it -> System.out.println(dp[it]));
    }

    private static void countTheNumberOfExpressions(int n, long[] dp) {
        dp[1] = 1; // 1
        dp[2] = dp[1] + 1; // 1+1, 2
        dp[3] = dp[1] + dp[2] + 1; // 1+1+1, 1+2, 2+1, 3

        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % MOD;
        }
    }
}
