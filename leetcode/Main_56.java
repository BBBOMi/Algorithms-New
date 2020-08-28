package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Bomi on 2020/08/28.
 * 문제 출처 : https://leetcode.com/problems/merge-intervals/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array, Sort
 * Used Data structure : Array
 */

public class Main_56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];

        Arrays.sort(intervals, Comparator.comparing((int[] arr) -> arr[0]));

        List<int[]> result = new ArrayList<>();
        int from = intervals[0][0];
        int to = intervals[0][1];

        for(int[] interval : intervals) {
            if(interval[0] <= to) {
                to = Math.max(interval[1], to);
                continue;
            }
            result.add(new int[]{from, to});
            from = interval[0];
            to = interval[1];
        }
        result.add(new int[]{from, to});
        return result.toArray(new int[0][]);
    }
}
