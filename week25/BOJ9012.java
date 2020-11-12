package me.algo.week25;

import java.io.*;
import java.util.Stack;

/**
 * Created by Bomi on 2020/11/12.
 * 문제 출처 : https://www.acmicpc.net/problem/9012
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조(Stack)
 * Used Data structure : Array, Stack
 */

public class BOJ9012 {
    private static final String VPS = "YES";
    private static final String NOT_VPS = "NO";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String ps = br.readLine();
            if(isVPS(ps)) sb.append(VPS);
            else sb.append(NOT_VPS);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static boolean isVPS(String parenthesisString) {
        Stack<Character> stack = new Stack<>();
        for (char bracket : parenthesisString.toCharArray()) {
            if(bracket == '(') {
                stack.push(bracket);
                continue;
            }
            if(stack.isEmpty()) return false;
            stack.pop();
        }
        return stack.isEmpty();
    }
}
