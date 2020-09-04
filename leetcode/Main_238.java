package me.algo.leetcode;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/09/04.
 * 문제 출처 : https://leetcode.com/problems/product-of-array-except-self/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class Main_238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        Arrays.fill(answer, 1);

        int multiplier = nums[0];
        for(int i=1; i<length; i++) {
            answer[i] *= multiplier;
            multiplier *= nums[i];
        }

        multiplier = nums[length-1];
        for(int i=length-2; i>=0; i--) {
            answer[i] *= multiplier;
            multiplier *= nums[i];
        }
        return answer;
    }
}
