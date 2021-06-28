package me.algo.week59;

import java.util.Stack;

/**
 * Created by Bomi on 2021/06/28.
 * 문제 출처 : https://leetcode.com/problems/evaluate-reverse-polish-notation/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Stack
 * Used Data structure : Stack, Array
 */

public class Leet150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperation(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = calculate(num1, num2, token);
                stack.push(result);
                continue;
            }
            stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    private boolean isOperation(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }

    private int calculate(int num1, int num2, String operation) {
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                throw new IllegalArgumentException();
        }
    }
}
