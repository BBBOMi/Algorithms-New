package me.algo;

import java.io.*;
import java.util.Stack;

/**
 * Created by Bomi on 2020/07/24.
 * 문제 출처 : https://www.acmicpc.net/problem/9012
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Stack, Array
 */

public class Main_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            bw.write(isVPS(br.readLine()) ? "YES" + "\n" : "NO" + "\n");
        }
        bw.close();
    }

    private static boolean isVPS(String str) {
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()) {
            if(c == '(') {
                stack.push(c);
                continue;
            }
            if(c == ')') {
                if(stack.isEmpty()) return false;
                if(stack.peek() != '(') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
