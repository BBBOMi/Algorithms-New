package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/28.
 * 문제 출처 : https://www.acmicpc.net/problem/1932
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n+1][n+1];
        dp[1][1] = arr[1][1];
        for(int i=2; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        System.out.println(Arrays.stream(dp[n]).max().getAsInt());
    }
}
