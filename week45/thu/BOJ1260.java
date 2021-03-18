package me.algo.week45.thu;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/03/16.
 * 문제 출처 : https://www.acmicpc.net/problem/1260
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS, BFS
 * Used Data structure : Queue(LinkedList), Array
 */

public class BOJ1260 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        boolean[][] matrix = new boolean[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            matrix[from][to] = matrix[to][from] = true;
        }

        dfs(matrix, new boolean[n + 1], v);
        bw.write("\n");
        bfs(matrix, new boolean[n + 1], v);

        bw.close();
    }

    private static void dfs(boolean[][] matrix, boolean[] visited, int start) throws IOException {
        bw.write(start + " ");
        visited[start] = true;
        for (int i = 1; i < matrix.length; i++) {
            if (!matrix[start][i] || visited[i]) continue;
            dfs(matrix, visited, i);
        }
    }

    private static void bfs(boolean[][] matrix, boolean[] visited, int start) throws IOException {
        Queue<Integer> points = new LinkedList<>();
        points.offer(start);
        visited[start] = true;

        while (!points.isEmpty()) {
            int current = points.poll();
            bw.write(current + " ");

            for (int i = 1; i < matrix.length; i++) {
                if (!matrix[current][i] || visited[i]) continue;
                points.offer(i);
                visited[i] = true;
            }
        }
    }

}
