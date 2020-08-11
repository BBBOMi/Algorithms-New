package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Bomi on 2020/08/11.
 * 문제 출처 : https://www.acmicpc.net/problem/2573
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : BFS, DFS
 * Used Data structure : Array
 */

public class Main_2573 {
    private static int n, m;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(countYears());
    }

    private static int countYears() {
        visited = new boolean[n][m];
        int[][] afterYear = new int[n][m];
        int years = 0;
        for (int count = countIcebergChunks(); count < 2; count = countIcebergChunks()) {
            if (count == 0) return 0;
            ++years;

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (map[i][j] > 0) {
                        afterYear[i][j] = countAroundIcebergs(i, j);
                    }
                }
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    map[i][j] -= afterYear[i][j];
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
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
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

            if (0 > nextX || nextX >= n || 0 > nextY || nextY >= m)
                continue;
            if (visited[nextX][nextY] || map[nextX][nextY] <= 0)
                continue;

            dfs(nextX, nextY);
        }
    }

    private static int countAroundIcebergs(int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (isIceberg(nextX, nextY)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isIceberg(int x, int y) {
        if (0 > x || x >= n || 0 > y || y >= m) return false;
        if (map[x][y] > 0) return false;
        return true;
    }
}
