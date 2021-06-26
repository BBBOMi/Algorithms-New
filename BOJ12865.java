package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/06/26.
 * 문제 출처 : https://www.acmicpc.net/problem/12865
 *
 * Time Complexity : O(N * K)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] items = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken()); // weight
            items[i][1] = Integer.parseInt(st.nextToken()); // value
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            int weight = items[i][0];
            int value = items[i][1];

            for (int j = 0; j <= k; j++) {
                if (j < weight) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
            }
        }

        System.out.println(dp[n][k]);
    }
}
