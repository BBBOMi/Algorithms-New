package me.algo.week51.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/04/26.
 * 문제 출처 : https://www.acmicpc.net/problem/1520
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class BOJ1520 {
    private static final int NOT_VISITED = -1;
    private static int height;
    private static int width;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        int[][] map = new int[height][width];
        int[][] dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = NOT_VISITED;
            }
        }

        System.out.println(dfs(0, 0, map, dp));
    }

    private static int dfs(int x, int y, int[][] map, int[][] dp) {
        if (x == (height - 1) && y == (width - 1)) return 1;
        if (dp[x][y] == NOT_VISITED) {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (nextX < 0 || nextX >= height || nextY < 0 || nextY >= width) continue;
                if (map[x][y] <= map[nextX][nextY]) continue;
                dp[x][y] += dfs(nextX, nextY, map, dp);
            }
        }
        return dp[x][y];
    }
}
