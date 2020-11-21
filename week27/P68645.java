package me.algo.week27;

import java.util.stream.IntStream;

/**
 * Created by Bomi on 2020/11/21.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/68645
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Simulation
 * Used Data structure : Array
 */

public class P68645 {
    private static int[] dx = {1, 0, -1};
    private static int[] dy = {0, 1, -1};

    public int[] solution(int n) {
        int[][] matrix = new int[n + 1][n + 1];
        int maxValue = IntStream.rangeClosed(1, n).reduce(Integer::sum).getAsInt();
        getEndValueAfterFillMatrix(matrix, n, 1, 1, 1, maxValue);
        return fillArray(matrix, maxValue);
    }

    private void getEndValueAfterFillMatrix(int[][] matrix, int n, int startX, int startY, int startValue, int maxValue) {
        int x = startX, y = startY;
        int direction = 0;
        matrix[x][y] = startValue++;
        while (startValue <= maxValue) {
            if (x + dx[direction] > n || y + dy[direction] > n) {
                direction = ++direction % 3;
                continue;
            }
            if (matrix[x + dx[direction]][y + dy[direction]] != 0) {
                direction = ++direction % 3;
                continue;
            }

            x += dx[direction];
            y += dy[direction];
            matrix[x][y] = startValue++;
        }
    }

    private int[] fillArray(int[][] matrix, int length) {
        int[] result = new int[length];
        int index = 0;
        final int LENGTH = matrix.length;
        for (int i = 1; i < LENGTH; i++) {
            for (int j = 1; j <= i; j++) {
                result[index++] = matrix[i][j];
            }
        }
        return result;
    }
}
