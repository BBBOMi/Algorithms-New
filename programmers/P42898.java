package me.algo.programmers;

/**
 * Created by Bomi on 2020/10/07.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42898
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class P42898 {
    private static final int MOD = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m + 1][n + 1];
        for (int[] puddle : puddles) {
            map[puddle[0]][puddle[1]] = -1;
        }

        int value = 1;
        for (int i = 1; i <= m; i++) {
            if (map[i][1] == -1) value = -1;
            map[i][1] = value;
        }
        value = 1;
        for (int i = 1; i <= n; i++) {
            if (map[1][i] == -1) value = -1;
            map[1][i] = value;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (map[i][j] == -1) continue;
                if (map[i - 1][j] != -1) map[i][j] = (map[i][j] + map[i - 1][j]) % MOD;
                if (map[i][j - 1] != -1) map[i][j] = (map[i][j] + map[i][j - 1]) % MOD;
            }
        }
        return map[m][n];
    }
}
