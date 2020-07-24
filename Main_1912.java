package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/07/24.
 * 문제 출처 : https://www.acmicpc.net/problem/1912
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n];
        for(int i=0; st.hasMoreTokens(); i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        int maxValue = dp[0] = numbers[0];
        for(int i=1; i<n; i++) {
            dp[i] = max(dp[i-1], 0) + numbers[i];
            maxValue = maxValue < dp[i] ? dp[i] : maxValue;
        }
        System.out.println(maxValue);
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
