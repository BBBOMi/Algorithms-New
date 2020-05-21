package me.algo.week1.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/05/19.
 * 문제 출처 : https://www.acmicpc.net/problem/1912
 * <p>
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        int maxValue = dp[1] = arr[1];
        for(int i=2; i<=n; i++) {
            dp[i] = max(dp[i-1] + arr[i], arr[i]);
            maxValue = max(maxValue, dp[i]);
        }
        System.out.println(maxValue);
    }

    private static int max(int a, int b) {
        return a > b ? a: b;
    }
}
