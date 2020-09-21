package me.algo.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by Bomi on 2020/09/20.
 * 문제 출처 : https://www.acmicpc.net/problem/2504
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Stack, Array
 */

public class Main_2504 {
    private static final int INCORRECT_BRACKET = 0;

    private static final int PARENTHESES = 2;
    private static final int BRACKETS = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calculate(br.readLine()));
    }

    private static int calculate(String brackets) {
        int sum = 0, multiply = 1;
        Stack<Character> stack = new Stack<>();
        char pre = 0;
        for (char bracket : brackets.toCharArray()) {
            switch (bracket) {
                case '(':
                    multiply *= PARENTHESES;
                    stack.push(bracket);
                    break;

                case '[':
                    multiply *= BRACKETS;
                    stack.push(bracket);
                    break;

                case ')':
                    if (stack.isEmpty()) return INCORRECT_BRACKET;
                    if (stack.pop() != '(') return INCORRECT_BRACKET;
                    if (pre == '(') sum += multiply;
                    multiply /= PARENTHESES;
                    break;

                case ']':
                    if (stack.isEmpty()) return INCORRECT_BRACKET;
                    if (stack.pop() != '[') return INCORRECT_BRACKET;
                    if (pre == '[') sum += multiply;
                    multiply /= BRACKETS;
            }
            pre = bracket;
        }
        return stack.isEmpty() ? sum : INCORRECT_BRACKET;
    }
}
