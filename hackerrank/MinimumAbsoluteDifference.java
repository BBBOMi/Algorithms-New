package me.algo.hackerrank;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/10/13.
 * 문제 출처 : https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class MinimumAbsoluteDifference {
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++) {
            min = Math.min(arr[i]-arr[i-1], min);
        }
        return min;
    }
}
