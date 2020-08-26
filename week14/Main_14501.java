package me.algo.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/24.
 * 문제 출처 : https://www.acmicpc.net/problem/14501
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_14501 {
    private static int n;

    private static int[] t;
    private static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        t = new int[n];
        p = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        for(int i=0; i<n; i++) {
            dp[i+1] = Integer.max(dp[i], dp[i+1]);

            if(i + t[i] <= n) {
                dp[i + t[i]] = Integer.max(dp[i + t[i]], dp[i] + p[i]);
            }
        }

        System.out.println(dp[n]);
    }
}
