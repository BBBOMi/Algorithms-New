package me.algo.week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/11/25.
 * 문제 출처 : https://www.acmicpc.net/problem/1783
 *
 * Time Complexity : O(1)
 * Used Algorithm : Case work
 */

public class BOJ1783 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        System.out.println(getStepCount(n, m));
    }

    private static int getStepCount(int height, int width) {
        final int UNCONSTRAINED_MAX_COUNT = 4;
        final int CONSTRAINED_MIN_WIDTH = 7;

        if (height == 1) return 1;
        if (height == 2) return Math.min(UNCONSTRAINED_MAX_COUNT, (width + 1) / 2);
        if (width < CONSTRAINED_MIN_WIDTH) return Math.min(UNCONSTRAINED_MAX_COUNT, width);
        return width - CONSTRAINED_MIN_WIDTH + (UNCONSTRAINED_MAX_COUNT + 1);
    }
}
