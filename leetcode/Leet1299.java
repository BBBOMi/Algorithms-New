package me.algo.leetcode;

/**
 * Created by Bomi on 2020/10/22.
 * 문제 출처 : https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class Leet1299 {
    public int[] replaceElements(int[] arr) {
        int[] answer = new int[arr.length];
        int index = arr.length - 1;
        int max = arr[index];
        answer[index] = -1;
        while (0 <= --index) {
            answer[index] = max;
            max = Math.max(max, arr[index]);
        }
        return answer;
    }
}
