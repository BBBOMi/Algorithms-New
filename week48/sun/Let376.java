package me.algo.week48.sun;

/**
 * Created by Bomi on 2021/04/08.
 * 문제 출처 : https://leetcode.com/problems/wiggle-subsequence/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Let376 {
    public int wiggleMaxLength(int[] nums) {
        int negative = 1, positive = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] - nums[i] > 0) positive = negative + 1;
            else if (nums[i - 1] - nums[i] < 0) negative = positive + 1;
        }
        return Math.max(negative, positive);
    }
}
