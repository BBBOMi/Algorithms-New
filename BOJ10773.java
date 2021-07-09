package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by Bomi on 2021/07/09.
 * 문제 출처 : https://www.acmicpc.net/problem/10773
 *
 * Time Complexity : O(N)
 * Used Algorithm : Stack
 * Used Data structure : Stack
 */

public class BOJ10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        Stack<Integer> numbers = new Stack<>();

        while (k-- > 0) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                numbers.pop();
                continue;
            }
            numbers.push(input);
        }
        System.out.println(numbers.stream().mapToInt(Integer::intValue).sum());
    }
}
