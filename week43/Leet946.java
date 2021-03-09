package me.algo.week43;

import java.util.Stack;

/**
 * Created by Bomi on 2021/03/09.
 * 문제 출처 : https://leetcode.com/problems/validate-stack-sequences/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Stack
 * Used Data structure : Array, Stack
 */

public class Leet946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int length = popped.length;
        int poppedIndex = 0;
        for (int pushNum : pushed) {
           stack.push(pushNum);
           while (poppedIndex < length && popped[poppedIndex] == stack.peek()) {
               stack.pop();
               poppedIndex++;
           }
        }
        return stack.isEmpty();
    }
}
