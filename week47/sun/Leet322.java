package me.algo.week47.sun;

import java.util.Arrays;

/**
 * Created by Bomi on 2021/04/01.
 * 문제 출처 : https://leetcode.com/problems/coin-change/
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Leet322 {
    private static final int CANT_MAKE = -1;
    private static final int MAX_VALUE = 10001;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        int[] counts = new int[amount + 1];
        Arrays.fill(counts, MAX_VALUE);
        counts[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                counts[i] = Math.min(counts[i], counts[i - coin] + 1);
            }
        }
        return counts[amount] != MAX_VALUE ? counts[amount] : CANT_MAKE;
    }
}
