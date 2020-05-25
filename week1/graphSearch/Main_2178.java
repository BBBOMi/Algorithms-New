package me.algo.week1.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/05/25.
 * 문제 출처 : https://www.acmicpc.net/problem/2178
 *
 * Time Complexity : O(N)
 * Used Algorithm :  BFS
 * Used Data structure : Array, Queue(LinkedList)
 */

public class Main_2178 {
    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n, m;

    private static int[][] maze;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(new Node(0, 0));
        System.out.println(maze[n-1][m-1]);
    }

    private static void bfs(Node start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(int i=0; i<4; i++) {
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if(!isAvailable(nextX, nextY)) {
                    continue;
                }

                queue.offer(new Node(nextX, nextY));
                maze[nextX][nextY] += maze[node.x][node.y];
            }
        }
    }

    private static boolean isAvailable(int x, int y) {
        if(0 > x || x >= n) return false;
        if(0 > y || y >= m) return false;
        if(maze[x][y] != 1) return false;
        return true;
    }
}
