package me.algo.week43;

import java.util.Stack;

/**
 * Created by Bomi on 2021/03/09.
 * 문제 출처 : https://leetcode.com/problems/score-of-parentheses/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Stack
 * Used Data structure : Array
 */

public class Leet856 {
    private static final char OPEN_PARENTHESIS = '(';

    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();

        int result = 0;
        for (char ch : S.toCharArray()) {
            if (ch == OPEN_PARENTHESIS) {
                stack.push(result);
                result = 0;
            } else {
                result = Math.max(1, result * 2) + stack.pop();
            }
        }
        return result;
    }
}
