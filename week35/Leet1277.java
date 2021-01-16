package me.algo.week35;

import static java.lang.Math.min;

/**
 * Created by Bomi on 2021/01/16.
 * 문제 출처 : https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Leet1277 {
    public int countSquares(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;

        int answer = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 0) continue;
                if (i == 0 || j == 0) answer += 1;
                else {
                    matrix[i][j] = min(matrix[i - 1][j - 1], min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                    answer += matrix[i][j];
                }
            }
        }
        return answer;
    }
}
