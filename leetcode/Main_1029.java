package me.algo.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Bomi on 2020/09/21.
 * 문제 출처 : https://leetcode.com/problems/two-city-scheduling/
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class Main_1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt((int[] arr) -> (arr[0] - arr[1])));

        int totalCost = 0;
        int halfLength = costs.length / 2;
        for (int i = 0; i < halfLength; i++) {
            totalCost += costs[i][0];
            totalCost += costs[halfLength + i][1];
        }
        return totalCost;
    }
}
