package me.algo.week14;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/25.
 * 문제 출처 : https://www.acmicpc.net/problem/9084
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] coins = new int[n + 1];
            for(int i=1; i<=n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];
            dp[0] = 1;
            for(int i=1; i<=n; i++) {
                for(int j=coins[i]; j<=m; j++) {
                    dp[j] += dp[j - coins[i]];
                }
            }
            bw.write(dp[m] + "\n");
        }
        bw.close();
    }
}
