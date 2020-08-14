package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/08/14.
 * 문제 출처 : https://www.acmicpc.net/problem/2749
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_2749 {
    private static final int MOD = 1000000;
    final static int PISANO_PERIOD = MOD / 10 * 15;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fibonacci(n));
    }

    private static int fibonacci(long n) {
        int lastIndex = (int)(n % PISANO_PERIOD);
        int[] dp = new int[lastIndex + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= lastIndex; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % MOD;
        }
        return dp[lastIndex];
    }
}
