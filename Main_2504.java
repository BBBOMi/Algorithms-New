package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by Bomi on 2020/08/14.
 * 문제 출처 : https://www.acmicpc.net/problem/2504
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Stack, Array
 */

public class Main_2504 {
    private static final int INCORRECT_BRACKETS = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String brackets = br.readLine();
        System.out.println(getBracketsScore(brackets));
    }

    private static int getBracketsScore(String brackets) {
        Stack<Character> stack = new Stack<>();
        int sum = 0, multiplier = 1;
        char pre = brackets.charAt(0);
        for (char bracket : brackets.toCharArray()) {
            if (bracket == '(' || bracket == '[') {
                stack.push(bracket);
                multiplier *= getScore(bracket);
            } else {
                if (stack.isEmpty()) return INCORRECT_BRACKETS;
                if (!isPair(stack.pop(), bracket)) return INCORRECT_BRACKETS;

                if (isPair(pre, bracket)) {
                    sum += multiplier;
                }
                multiplier /= getScore(bracket);
            }
            pre = bracket;
        }
        return stack.isEmpty() ? sum : INCORRECT_BRACKETS;
    }

    private static boolean isPair(char from, char to) {
        if (from == '(') return to == ')';
        if (from == '[') return to == ']';
        return false;
    }

    private static int getScore(char bracket) {
        return bracket == '(' || bracket == ')' ? 2 : 3;
    }
}
