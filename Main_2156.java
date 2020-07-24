package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/07/24.
 * 문제 출처 : https://www.acmicpc.net/problem/2156
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wines = new int[n+1];
        for(int i=1; i<=n; i++) {
            wines[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(getMaxWines(wines));
    }

    private static int getMaxWines(int[] wines) {
        int length = wines.length;
        if(length == 2) return wines[1];

        int[] dp = new int[length];
        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];
        for(int i=3; i<length; i++) {
            dp[i] = max(dp[i-3] + wines[i-1] + wines[i], dp[i-2] + wines[i], dp[i-1]);
        }
        return dp[length-1];
    }

    private static int max(int a, int b, int c) {
        if(a > b) return c > a ? c : a;
        return c > b ? c : b;
    }
}
