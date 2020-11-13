package me.algo.week25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/11/13.
 * 문제 출처 : https://www.acmicpc.net/problem/2493
 *
 * Time Complexity : O(N^2)(worst-case)
 * Used Algorithm : 자료구조(Stack)
 * Used Data structure : Stack
 */

public class BOJ2493 {
    static class Tower {
        int index;
        int height;

        Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder answer = new StringBuilder();
        Stack<Tower> stack = new Stack<>();
        int index = 0;
        while (++index <= n) {
            int currentTowerHeight = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().height < currentTowerHeight) {
                stack.pop();
            }

            if (stack.isEmpty()) answer.append(0).append(" ");
            else answer.append(stack.peek().index).append(" ");
            stack.push(new Tower(index, currentTowerHeight));
        }
        System.out.println(answer.toString());
    }
}
