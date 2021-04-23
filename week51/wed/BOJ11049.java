package me.algo.week51.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/04/23.
 * 문제 출처 : https://www.acmicpc.net/problem/11049
 *
 * Time Complexity : O(N ^ 3)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class BOJ11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, arr));
    }

    private static int solution(int n, int[][] arr) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < n; i++) {
            dp[i][i + 1] = arr[i][0] * arr[i][1] * arr[i + 1][1];
        }

        for (int diff = 2; diff <= n; diff++) {
            for (int start = 1; start <= n - diff; start++) {
                int end = start + diff;
                for (int mid = start; mid < end; mid++) {
                    int count = dp[start][mid] + dp[mid + 1][end] + arr[start][0] * arr[mid][1] * arr[end][1];
                    if (dp[start][end] == 0 || count < dp[start][end]) dp[start][end] = count;
                }
            }
        }
        return dp[1][n];
    }
}
