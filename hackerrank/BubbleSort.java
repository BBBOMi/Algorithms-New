package me.algo.hackerrank;

/**
 * Created by Bomi on 2020/10/06.
 * 문제 출처 : https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : sort
 * Used Data structure : Array
 */

public class BubbleSort {
    private static int count;

    static void countSwaps(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) continue;
                swap(i, j, a);
                count++;
            }
        }
    }

    private static void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
