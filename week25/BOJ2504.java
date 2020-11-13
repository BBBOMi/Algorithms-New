package me.algo.week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by Bomi on 2020/11/13.
 * 문제 출처 : https://www.acmicpc.net/problem/2504
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조(Stack)
 * Used Data structure : Stack, Array
 */

public class BOJ2504 {
    private static final int PARENTHESES = 2;
    private static final int BRACKETS = 3;

    private static final int INCORRECT_BRACKETS = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brackets = br.readLine();
        System.out.println(countBracketsValue(brackets));
    }

    private static int countBracketsValue(String brackets) {
        int sum = 0, multiplier = 1;
        Stack<Character> stack = new Stack<>();
        char pre = '0';

        for (char current : brackets.toCharArray()) {
            switch (current) {
                case '(':
                    stack.push(current);
                    multiplier *= PARENTHESES;
                    break;
                case ')':
                    if (stack.isEmpty()) return INCORRECT_BRACKETS;
                    if (stack.pop() != '(') return INCORRECT_BRACKETS;
                    if (pre == '(') sum += multiplier;
                    multiplier /= PARENTHESES;
                    break;
                case '[':
                    stack.push(current);
                    multiplier *= BRACKETS;
                    break;
                case ']':
                    if (stack.isEmpty()) return INCORRECT_BRACKETS;
                    if (stack.pop() != '[') return INCORRECT_BRACKETS;
                    if (pre == '[') sum += multiplier;
                    multiplier /= BRACKETS;
            }
            pre = current;
        }
        return stack.isEmpty() ? sum : INCORRECT_BRACKETS;
    }
}
