package me.algo.leetcode;

/**
 * Created by Bomi on 2020/07/31.
 * 문제 출처 : https://leetcode.com/problems/minimum-path-sum/
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_64 {
    public int minPathSum(int[][] grid) {
        int w = grid[0].length;
        int h = grid.length;

        int[][] dp = new int[h+1][w+1];
        for(int i=1; i<=h; i++) {
            for(int j=1; j<=w; j++) {
                dp[i][j] = grid[i-1][j-1];
                if(i == 1) {
                    dp[i][j] += dp[i][j-1];
                    continue;
                }
                if(j == 1) {
                    dp[i][j] += dp[i-1][j];
                    continue;
                }
                dp[i][j] += min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[h][w];
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
