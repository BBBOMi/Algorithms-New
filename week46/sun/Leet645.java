package me.algo.week46.sun;

import java.util.Arrays;

/**
 * Created by Bomi on 2021/03/24.
 * 문제 출처 : https://leetcode.com/problems/set-mismatch/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class Leet645 {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[nums.length + 1];
        Arrays.stream(nums).forEach(it -> arr[it]++);

        int duplicated = 0, missed = 0;
        for (int i = 1; i <= nums.length; i++) {
            if(nums[i] == 2) duplicated = i;
            else if(nums[i] == 0) missed = i;
        }
        return new int[]{duplicated, missed};
    }
}
