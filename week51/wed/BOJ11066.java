package me.algo.week51.wed;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/04/23.
 * 문제 출처 : https://www.acmicpc.net/problem/11066
 *
 * Time Complexity : O(N ^ 3)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class BOJ11066 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            int[] cost = new int[k + 1];
            int[] sum = new int[k + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= k; i++) {
                cost[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + cost[i];
            }

            int[][] dp = new int[k + 1][k + 1];
            for (int diff = 1; diff < k; diff++) {
                for (int start = 1; start + diff <= k; start++) {
                    int end = start + diff;
                    dp[start][end] = Integer.MAX_VALUE;

                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end] + sum[end] - sum[start - 1]);
                    }
                }
            }
            bw.write(dp[1][k] + "\n");
        }
        bw.close();
    }
}
