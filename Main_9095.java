package me.algo;

import java.io.*;

/**
 * Created by Bomi on 2020/07/24.
 * 문제 출처 : https://www.acmicpc.net/problem/9095
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(countSum(n) + "\n");
        }
        bw.close();
    }

    private static int countSum(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
