package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/09/08.
 * 문제 출처 : https://www.acmicpc.net/problem/17070
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DFS
 * Used Data structure : Array
 */

public class Main_17070 {
    private static int n;
    private static int[][] house;

    // 가로, 세로, 대각선
    private static int[] dx = {0, 1, 1};
    private static int[] dy = {1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        house = new int[n+1][n+1];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                house[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(countMovedPipe(0, 1, 0));
    }

    private static int countMovedPipe(int x, int y, int pipe) {
        int count = 0;
        if(x == n-1 && y == n-1) {
            return ++count;
        }

        for(int i=0; i<3; i++) {
            if((i == 0 && pipe == 1) || (i == 1 && pipe == 0)) continue;

            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= n || nextY >= n) continue;
            if(house[nextX][nextY] == 1) continue;

            if(i == 2 && (house[x][y+1] == 1 || house[x+1][y] == 1)) continue;

            count += countMovedPipe(nextX, nextY, i);
        }
        return count;
    }
}
