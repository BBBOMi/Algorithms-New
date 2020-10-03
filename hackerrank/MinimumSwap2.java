package me.algo.hackerrank;

/**
 * Created by Bomi on 2020/10/03.
 * 문제 출처 : https://www.hackerrank.com/challenges/minimum-swaps-2/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class MinimumSwap2 {
    static int minimumSwaps(int[] arr) {
        final int LENGTH = arr.length;
        int count = 0;
        for (int i = 0; i < LENGTH; i++) {
            if (arr[i] == (i + 1)) continue;
            swap(i, arr[i] - 1, arr);
            count++;
            i--;
        }
        return count;
    }

    private static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
