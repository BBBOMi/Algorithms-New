package me.algo.week6.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/06/25.
 * 문제 출처 : https://www.acmicpc.net/problem/1965
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : dp, LIS(Longest Increasing Subsequence)
 * Used Data structure : Array
 */

public class Main_1965 {
    private static int maxValue = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; st.hasMoreElements(); i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            countBoxes(i, arr, dp);
        }
        System.out.println(maxValue);
    }

    private static void countBoxes(int index, int[] arr, int[] dp) {
       for(int i=1; i<index; i++) {
           dp[index] = arr[index] > arr[i] ?
                   max(dp[index], dp[i] + 1) : dp[index];
       }
        maxValue = max(maxValue, dp[index]);
    }

    private static int max(int a, int b){
        return a > b ? a : b;
    }
}
