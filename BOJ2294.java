package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * Created by Bomi on 2021/03/18.
 * 문제 출처 : https://www.acmicpc.net/problem/2294
 *
 * Time Complexity : O(N * K)
 * Used Algorithm : DP
 * Used Data structure : Array, Set(TreeSet)
 */

public class BOJ2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Set<Integer> coins = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            coins.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(minCount(coins, k));
    }

    private static int minCount(Set<Integer> coins, int k) {
        final int MAX_VALUE = 10001;
        final int NO_WAY = -1;

        int[] minCounts = new int[k + 1];
        Arrays.fill(minCounts, MAX_VALUE);
        minCounts[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                minCounts[i] = Math.min(minCounts[i], minCounts[i - coin] + 1);
            }
        }
        return minCounts[k] >= MAX_VALUE ? NO_WAY : minCounts[k];
    }
}
