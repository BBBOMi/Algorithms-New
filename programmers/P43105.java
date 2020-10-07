package me.algo.programmers;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/10/07.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/43105
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class P43105 {
    public int solution(int[][] triangle) {
        final int LENGTH = triangle.length;
        for (int i = 1; i < LENGTH; i++) {
            triangle[i][0] += triangle[i - 1][0];
            triangle[i][i] += triangle[i - 1][i];
            for (int j = 1; j < i; j++) {
                triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
            }
        }
        return Arrays.stream(triangle[LENGTH - 1]).max().getAsInt();
    }
}
