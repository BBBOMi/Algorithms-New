package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

/**
 * Created by Bomi on 2020/08/20.
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

        int[] arr = new int[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(getMaxScore(arr));
    }

    private static int getMaxScore(int[] arr) {
        int n = arr.length-1;

        if(n < 2) return arr[1];
        if(n < 3) return arr[1] + arr[2];

        int[] dp = new int[n+1];
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = max(arr[1], arr[2]) + arr[3];
        for(int i=4; i<=n; i++) {
            dp[i] = max(dp[i-3] + arr[i-1], dp[i-2]) + arr[i];
        }
        return dp[n];
    }
}
