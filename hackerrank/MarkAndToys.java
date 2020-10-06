package me.algo.hackerrank;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/10/06.
 * 문제 출처 : https://www.hackerrank.com/challenges/mark-and-toys/problem
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Sort
 * Used Data structure : Array
 */

public class MarkAndToys {
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int count = 0;
        for (int price : prices) {
            if (k - price < 0) break;
            k -= price;
            count++;
        }
        return count;
    }
}
