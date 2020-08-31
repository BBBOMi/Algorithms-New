package me.algo.week15.programmers;

import java.util.Stack;

/**
 * Created by Bomi on 2020/08/18.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/60058
 *
 * Time Complexity : O(N)
 * Used Algorithm : Recursion
 * Used Data structure : Stack, Array
 */

public class Main_60058 {
    public String solution(String p) {
        if (p.isEmpty()) return p;

        String u = "", v = "";
        int openCount = 0, closeCount = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') openCount++;
            else closeCount++;
            if (openCount > 0 && openCount == closeCount) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        if (isPair(u)) u += solution(v);
        else {
            String temp = "(";
            temp += solution(v);
            temp += ")";
            u = u.substring(1, u.length() - 1);
            for (char c : u.toCharArray()) {
                if (c == '(') c = ')';
                else c = '(';
                temp += c;
            }
            return temp;
        }
        return u;
    }

    private static boolean isPair(String u) {
        Stack<Character> stack = new Stack<>();
        for (char c : u.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) return false;
            stack.pop();
        }
        return stack.isEmpty();
    }
}
