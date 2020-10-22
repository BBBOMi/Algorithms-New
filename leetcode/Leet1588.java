package me.algo.leetcode;


/**
 * Created by Bomi on 2020/10/20.
 * 문제 출처 : https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class Leet1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0, length = arr.length;
        for (int i = 0; i < length; i++) {
            sum += ((i + 1) * (length - i) + 1) / 2 * arr[i];
        }
        return sum;
    }
}