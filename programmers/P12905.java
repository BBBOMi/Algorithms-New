package me.algo.programmers;

/**
 * Created by Bomi on 2020/10/08.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12905
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class P12905 {
    public int solution(int[][] board) {
        int height = board.length;
        int width = board[0].length;
        int answer = 0;

        int[][] map = new int[height + 1][width + 1];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                map[i + 1][j + 1] = board[i][j];
            }
        }

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if (map[i][j] == 0) continue;
                map[i][j] = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]) + 1;
                answer = Math.max(answer, map[i][j]);
            }
        }
        return answer * answer;
    }
}
