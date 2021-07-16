package me.algo;

import java.util.Stack;

/**
 * Created by Bomi on 2021/07/16.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/76502
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Stack
 * Used Data structure : Stack
 */

public class P76502 {
    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isCorrectParenthesis(s.substring(i) + s.substring(0, i))) {
                answer++;
            }
        }
        return answer;
    }

    private boolean isCorrectParenthesis(String s) {
        Stack<Character> stack = new Stack<>();
        for (char current : s.toCharArray()) {
            if (isOpenParenthesis(current)) {
                stack.push(current);
                continue;
            }

            if (stack.isEmpty()) return false;
            if (!isPair(current, stack.peek())) return false;
            stack.pop();
        }
        return stack.isEmpty();
    }

    private boolean isOpenParenthesis(char current) {
        return current == '(' || current == '{' || current == '[';
    }

    private boolean isPair(char current, char stackChar) {
        return (current == ')' && stackChar == '(')
                || (current == '}' && stackChar == '{')
                || (current == ']' && stackChar == '[');
    }
}
