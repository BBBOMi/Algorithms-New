package me.algo.week43;

import java.util.Arrays;

/**
 * Created by Bomi on 2021/03/09.
 * 문제 출처 : https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class Leet581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] copied = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copied);

        int from = nums.length, to = 0;
        for (int i = 0; i < nums.length; i++) {
            if (copied[i] == nums[i]) continue;
            from = Math.min(from, i);
            to = Math.max(to, i);
        }
        return to - from >= 0 ? to - from + 1 : 0;
    }
}
