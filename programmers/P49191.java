package me.algo.programmers;

/**
 * Created by Bomi on 2020/09/25.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/49191
 *
 * Time Complexity : O(N^3)
 * Used Algorithm : Floyd-Warshall
 * Used Data structure : Array
 */

public class P49191 {
    public int solution(int n, int[][] results) {
        boolean[][] winResults = new boolean[n + 1][n + 1];
        for (int[] result : results) {
            winResults[result[0]][result[1]] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (winResults[j][i] && winResults[i][k]) {
                        winResults[j][k] = true;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (winResults[i][j] || winResults[j][i]) count++;
            }
            if (count == n - 1) answer++;
        }
        return answer;
    }
}
