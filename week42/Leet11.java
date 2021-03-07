package me.algo.week42;

/**
 * Created by Bomi on 2021/03/07.
 * 문제 출처 : https://leetcode.com/problems/container-with-most-water/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Two-pointers
 * Used Data structure : Array
 */

public class Leet11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, currentArea(left, right, height));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    private int currentArea(int left, int right, int[] height) {
        return Math.min(height[left], height[right]) * (right - left);
    }
}
