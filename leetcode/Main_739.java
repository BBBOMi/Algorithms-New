package me.algo.leetcode;

import java.util.Stack;

/**
 * Created by Bomi on 2020/08/19.
 * 문제 출처 : https://leetcode.com/problems/daily-temperatures/
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Stack, Array
 */

public class Main_739 {
    public int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int[] result = new int[length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
