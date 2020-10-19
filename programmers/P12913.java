package me.algo.programmers;


import java.util.Arrays;

/**
 * Created by Bomi on 2020/10/19.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12913
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class P12913 {
    public int solution(int[][] land) {
        final int LENGTH = land.length;
        for (int i = 1; i < LENGTH; i++) {
            land[i][0] += max(land[i - 1][1], land[i - 1][2], land[i - 1][3]);
            land[i][1] += max(land[i - 1][0], land[i - 1][2], land[i - 1][3]);
            land[i][2] += max(land[i - 1][0], land[i - 1][1], land[i - 1][3]);
            land[i][3] += max(land[i - 1][0], land[i - 1][1], land[i - 1][2]);
        }
        return Arrays.stream(land[LENGTH - 1]).max().getAsInt();
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
