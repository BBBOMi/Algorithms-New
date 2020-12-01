package me.algo.week28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/12/01.
 * 문제 출처 : https://www.acmicpc.net/problem/11404
 *
 * Time Complexity : O(N^3)
 * Used Algorithm : Floyd-warshall
 * Used Data structure : Array
 */

public class BOJ11404 {
    private static final int MAX_COST = 100000 * 100; // 최대비용 * 최대도시수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];
        Arrays.stream(map).forEach((int[] line) -> Arrays.fill(line, MAX_COST));

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            map[from][to] = Math.min(map[from][to], cost);
        }

        floyd(n, map);
        System.out.println(toString(n, map));
    }

    private static void floyd(int n, int[][] map) {
        for (int via = 1; via <= n; via++) {
            for (int from = 1; from <= n; from++) {
                for (int to = 1; to <= n; to++) {
                    if (from == to) continue;
                    if (map[from][to] <= map[from][via] + map[via][to]) continue;
                    map[from][to] = map[from][via] + map[via][to];
                }
            }
        }
    }

    private static String toString(int n, int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] == MAX_COST) map[i][j] = 0;
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
