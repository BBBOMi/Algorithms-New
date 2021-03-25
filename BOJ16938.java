package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/03/25.
 * 문제 출처 : https://www.acmicpc.net/problem/16938
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Back-tracking
 * Used Data structure : Array
 */

public class BOJ16938 {
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] levels = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            levels[i] = Integer.parseInt(st.nextToken());
        }

        solution(levels, l, r, x, Integer.MAX_VALUE, Integer.MIN_VALUE, 0, 0);
        System.out.println(count);
    }

    private static void solution(int[] levels, int low, int high, int diff, int min, int max, int sum, int index) {
        if (canIncrease(low, high, sum, diff, max - min)) count++;
        if (index == levels.length) return;

        for (int i = index; i < levels.length; i++) {
            solution(levels, low, high, diff, Math.min(min, levels[i]), Math.max(max, levels[i]), sum + levels[i], i + 1);
        }
    }

    private static boolean canIncrease(int low, int high, int sum, int diffStandard, int diff) {
        return low <= sum && sum <= high && diffStandard <= diff;
    }
}
