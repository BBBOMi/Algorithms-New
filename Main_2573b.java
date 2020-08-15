package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/15.
 * 문제 출처 : https://www.acmicpc.net/problem/2573
 *
 * Time Complexity :O(N)
 * Used Algorithm : BFS, DFS
 * Used Data structure : Array
 */

public class Main_2573b {
    private static int h, w;

    private static int[][] icebergs;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        icebergs = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                icebergs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(countYears());
    }

    private static int countYears() {
        int[][] afterYears = new int[h][w];
        visited = new boolean[h][w];

        int chunks, years = 0;
        while ((chunks = countIcebergChunks()) < 2) {
            if (chunks == 0) return 0;

            years++;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (icebergs[i][j] > 0) {
                        afterYears[i][j] = countAround(i, j);
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    icebergs[i][j] -= afterYears[i][j];
                }
            }
        }
        return years;
    }

    private static int countIcebergChunks() {
        for (boolean[] array : visited) {
            Arrays.fill(array, false);
        }
        int count = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visited[i][j] && icebergs[i][j] > 0) {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (0 > nextX || nextX >= h || 0 > nextY || nextY >= w) {
                continue;
            }

            if (!visited[nextX][nextY] && icebergs[nextX][nextY] > 0) {
                dfs(nextX, nextY);
            }
        }
    }

    private static int countAround(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isCountable(nextX, nextY)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isCountable(int x, int y) {
        if (0 > x || x >= h || 0 > y || y >= w) return false;
        if (icebergs[x][y] > 0) return false;
        return true;
    }
}
