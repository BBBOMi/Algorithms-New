package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/03/19.
 * 문제 출처 : https://www.acmicpc.net/problem/2565
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class BOJ2565 {
    private static class Line {
        int from;
        int to;

        Line(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Line[] lines = new Line[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            lines[i] = new Line(from, to);
        }

        Arrays.sort(lines, Comparator.comparingInt((Line line) -> line.from));

        int count = 0;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (lines[i].to < lines[j].to) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            count = Math.max(count, dp[i]);
        }
        System.out.println(n - count);
    }
}
