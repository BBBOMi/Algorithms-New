package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/20.
 * 문제 출처 : https://www.acmicpc.net/problem/2468
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DFS
 * Used Data structure : Array
 */

public class Main_2468 {
    private static int n;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int count = countSafeLands(map); count > 0; count = countSafeLands(map)) {
            if(count > max) max = count;
            raining(map);
        }
        System.out.println(max);
    }

    private static int countSafeLands(int[][] map) {
        visited = new boolean[n][n];
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && map[i][j] > 0) {
                    count++;
                    dfs(i, j, map);
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y, int[][] map) {
        visited[x][y] = true;
        for(int i=0; i<4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(0 > nextX || nextX >= n || 0 > nextY || nextY >= n) {
                continue;
            }
            if(visited[nextX][nextY] || map[nextX][nextY] <= 0) {
                continue;
            }
            dfs(nextX, nextY, map);
        }
    }

    private static void raining(int[][] map) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                --map[i][j];
            }
        }
    }
}
