package me.algo.week1.graphSearch;

import java.io.*;
import java.util.*;

/**
 * Created by Bomi on 2020/05/21.
 * 문제 출처 : https://www.acmicpc.net/problem/1260
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DFS, BFS
 * Used Data structure : Array, Queue(LinkedList)
 */

public class Main_1260 {
    private static int[][] matrix;
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        matrix = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            matrix[from][to] = matrix[to][from] = 1;
        }

        dfs(v, new boolean[n + 1]);
        bw.write("\n");
        bfs(v, new boolean[n + 1]);

        bw.flush();
        bw.close();
    }

    private static void dfs(int start, boolean[] visited) throws IOException {
        visited[start] = true;
        bw.write(start + " ");
        for(int i=1, len=matrix.length; i<len; i++) {
            if(visited[i]) continue;
            if(matrix[start][i] == 1) {
                dfs(i, visited);
            }
        }
    }

    private static void bfs(int start, boolean[] visited) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while(!queue.isEmpty()) {
            int v = queue.poll();
            bw.write(v + " ");
            for(int i=1, len=matrix[v].length; i<len; i++) {
                if(visited[i]) continue;
                if(matrix[v][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
