package me.algo;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/07/09.
 * 문제 출처 : https://www.acmicpc.net/problem/9465
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_9465 {
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n];
            for(int j=0; j<2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0; k<n; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            printMaxValue(stickers);
        }
        bw.close();
    }

    private static void printMaxValue(int[][] arr) throws IOException {
        int h = arr.length;
        int w = arr[0].length;
        int[][] dp = new int[h][w];
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        for(int i=1; i<w; i++) {
            dp[0][i] = max(dp[0][i-1], dp[1][i-1] + arr[0][i]);
            dp[1][i] = max(dp[1][i-1], dp[0][i-1] + arr[1][i]);
        }
        bw.write(max(dp[0][w-1], dp[1][w-1]) + "\n");
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }
}
