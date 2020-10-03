package me.algo.hackerrank;


/**
 * Created by Bomi on 2020/10/03.
 * 문제 출처 : https://www.hackerrank.com/challenges/crush/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class ArrayManipulation {
    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n + 1];
        for (int[] query : queries) {
            array[query[0] - 1] += query[2];
            array[query[1]] -= query[2];
        }

        long max = 0, sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += array[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}
