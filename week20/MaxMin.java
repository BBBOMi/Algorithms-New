package me.algo.week20;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/09/29.
 * 문제 출처 : https://www.hackerrank.com/challenges/angry-children/problem
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class MaxMin {
    static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        for (int i = k; i <= arr.length; i++) {
            int diff = arr[i - 1] - arr[i - k];
            if (minDiff > diff) minDiff = diff;
        }
        return minDiff;
    }
}
