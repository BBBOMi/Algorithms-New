package me.algo.week49.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2021/04/10.
 * 문제 출처 : https://www.acmicpc.net/problem/1676
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 */

public class BOJ1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(countLastZero(n));
    }

    private static int countLastZero(int n) {
        int fiveCount = 0;
        for (int i = 2; i <= n; i++) {
            int current = i;
            while (current % 5 == 0) {
                fiveCount++;
                current /= 5;
            }
        }
        return fiveCount;
    }
}
