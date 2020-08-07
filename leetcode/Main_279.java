package me.algo.leetcode;

import java.util.stream.IntStream;

/**
 * Created by Bomi on 2020/08/07.
 * 문제 출처 : https://leetcode.com/problems/perfect-squares/
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DP
 * Used Data structure : Arrays
 */

public class Main_279 {
    public int numSquares(int n) {
        int[] countNumbers = IntStream.rangeClosed(0, n).toArray();
        int row = (int) Math.sqrt(n) + 1;
        for (int i = 1; i <= row; i++) {
            int value = i * i;
            for (int j = 1; j <= n; j++) {
                if (value <= j) {
                    countNumbers[j] = min(countNumbers[j], countNumbers[j-value]+1);
                }
            }
        }
        return countNumbers[n];
    }

    private static int min(int a, int b) {
        return a < b ? a : b;
    }
}
