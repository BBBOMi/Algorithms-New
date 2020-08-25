package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;

/**
 * Created by Bomi on 2020/08/25.
 * 문제 출처 : https://www.acmicpc.net/problem/11722
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);

        int maxValue = 0;
        for (int i = n; i > 0; i--) {
            for (int j = n; j > i; j--) {
                if (arr[i] > arr[j]) {
                    dp[i] = max(dp[j] + 1, dp[i]);
                }
            }
            if(dp[i] > maxValue) maxValue = dp[i];
        }
        System.out.println(maxValue);
    }
}
