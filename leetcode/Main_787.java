package me.algo.leetcode;


/**
 * Created by Bomi on 2020/09/23.
 * 문제 출처 : https://leetcode.com/problems/cheapest-flights-within-k-stops/
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DFS
 * Used Data structure : Array
 */

public class Main_787 {
    private static int minCost;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] cost = new int[n][n];
        for (int[] flight : flights) {
            cost[flight[0]][flight[1]] = flight[2];
        }

        minCost = Integer.MAX_VALUE;
        dfs(src, dst, K, cost, -1, 0);
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    private static void dfs(int src, int dst, int k, int[][] cost, int via, int totalCost) {
        if (via > k || totalCost > minCost) return;
        if (src == dst) {
            minCost = Math.min(minCost, totalCost);
            return;
        }

        for (int i = 0; i < cost.length; i++) {
            if (cost[src][i] == 0) continue;
            dfs(i, dst, k, cost, via + 1, totalCost + cost[src][i]);
        }
    }
}
