package me.algo.leetcode;

/**
 * Created by Bomi on 2020/08/11.
 * 문제 출처 : https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_746 {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int[] dp = new int[length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i=2; i<length; i++) {
            dp[i] = min(dp[i-2], dp[i-1]) + cost[i];
        }
        return min(dp[length-1], dp[length-2]);
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
