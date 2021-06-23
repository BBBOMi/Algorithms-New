package me.algo.week58;

import java.util.Arrays;

/**
 * Created by Bomi on 2021/06/23.
 * 문제 출처 : https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : Array
 */

public class Leet462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        var middle = nums[nums.length / 2];

        var steps = 0;
        for (int num : nums) {
            steps += Math.abs(num - middle);
        }
        return steps;
    }
}
