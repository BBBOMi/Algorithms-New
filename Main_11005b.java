package me.algo;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/07/28.
 * 문제 출처 : https://www.acmicpc.net/problem/11005
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Stack
 */

public class Main_11005b {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        while(n > 0) {
            stack.push(n % b);
            n /= b;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(!stack.isEmpty()) {
            bw.write(stack.peek() < 10 ? String.valueOf(stack.pop()) : String.valueOf((char)(stack.pop() + 55)));
        }
        bw.close();
    }
}
