package me.algo.hackerrank;

/**
 * Created by Bomi on 2020/10/02.
 * 문제 출처 : https://www.hackerrank.com/challenges/2d-array/problem
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Array
 * Used Data structure : array
 */

public class DS {
    private static final int MIN_VALUE = -9 * 7;

    static int hourglassSum(int[][] arr) {
        int maxSum = MIN_VALUE;
        final int LENGTH = arr.length;
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                maxSum = Math.max(maxSum, sum(i, j, arr));
            }
        }
        return maxSum;
    }

    private static int sum(int x, int y, int[][] arr) {
        if (x + 2 >= arr.length) return MIN_VALUE;
        if (y + 2 >= arr.length) return MIN_VALUE;

        int sum = arr[x + 1][y + 1];
        for (int i = 0; i < 3; i += 2) {
            for (int j = 0; j < 3; j++) {
                sum += arr[x + i][y + j];
            }
        }
        return sum;
    }

}
