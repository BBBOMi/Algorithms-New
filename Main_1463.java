package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/07/23.
 * 문제 출처 : https://www.acmicpc.net/problem/1463
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(countMakeOne(n));
    }

    private static int countMakeOne(int n) {
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 3 == 0) {
                dp[i] = min(dp[i], dp[i/3] + 1);
            } else if(i % 2 == 0) {
                dp[i] = min(dp[i], dp[i/2] + 1);
            }
        }
        return dp[n];
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
