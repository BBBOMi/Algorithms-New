package me.algo.leetcode;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/09/23.
 * 문제 출처 : https://leetcode.com/problems/maximum-product-of-three-numbers/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : Array
 */

public class Main_628 {
    // Time Complexity : O(N log N) / Space Complexity : O(log N)
 /*   public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[2],
                nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
    }*/

    // Time Complexity : O(N) / Space Complexity : O(1)
    public int maximumProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

        for(int num : nums) {
            if(firstMax < num) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = num;
            } else if(secondMax < num) {
                thirdMax = secondMax;
                secondMax = num;
            } else if(thirdMax < num) {
                thirdMax = num;
            }
            if(firstMin > num) {
                secondMin = firstMin;
                firstMin = num;
            } else if(secondMin > num) {
                secondMin = num;
            }
        }
        return Math.max(firstMax * secondMax * thirdMax, firstMin * secondMin * firstMax);
    }
}
