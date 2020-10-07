package me.algo.leetcode;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/10/07.
 * 문제 출처 : https://leetcode.com/problems/non-overlapping-intervals/
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class Leet435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (int[] arr1, int[] arr2) -> arr1[1] == arr2[1] ? arr1[0] - arr2[0] : arr1[1] - arr2[1]);
        int count = 0;
        int to = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (to <= intervals[i][0]) {
                to = intervals[i][1];
                continue;
            }
            count++;
        }
        return count;
    }
}
