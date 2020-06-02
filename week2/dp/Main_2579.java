package me.algo.week2.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/05/26.
 * 문제 출처 : https://www.acmicpc.net/problem/2579
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(stepUp(arr));
    }

    private static int stepUp(int[] arr) {
        int length = arr.length;
        if(length <= 1) return arr[0];
        if(length <= 2) return arr[0] + arr[1];

        int[] dp = new int[length];
        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = max(arr[0], arr[1]) + arr[2];
        for(int i=3; i<length; i++) {
            dp[i] = max(dp[i-2], dp[i-3]+arr[i-1]) + arr[i];
        }
        return dp[length-1];
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
