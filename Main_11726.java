package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/07/24.
 * 문제 출처 : https://www.acmicpc.net/problem/11726
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_11726 {
    private static final int MOD = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(countWaysToFillTheTiles(n));
    }

    private static int countWaysToFillTheTiles(int n) {
        if(n == 1) return 1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % MOD;
        }
        return dp[n];
    }
}
