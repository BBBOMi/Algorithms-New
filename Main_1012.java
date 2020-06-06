package me.algo;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/06/06.
 * 문제 출처 : https://www.acmicpc.net/problem/1012
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : BFS
 * Used Data structure : Array, Queue(LinkedList)
 */

public class Main_1012 {
    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[][] map;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]
                        = 1;
            }
            bw.write(countCabbage() + "\n");
        }
        bw.close();
    }

    private static int countCabbage() {
        int count = 0;
        for (int i = 0, height = map.length; i < height; i++) {
            for (int j = 0, width = map[0].length; j < width; j++) {
                if (map[i][j] != 1) {
                    continue;
                }
                map[i][j] = 0;
                bfs(new Node(i, j));
                count++;
            }
        }
        return count;
    }

    private static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node present = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = present.x + dx[i];
                int nextY = present.y + dy[i];

                if (!isAvailable(nextX, nextY))
                    continue;

                queue.offer(new Node(nextX, nextY));
                map[nextX][nextY] = 0;
            }
        }
    }

    private static boolean isAvailable(int x, int y) {
        if (0 > x || x >= map.length || 0 > y || y >= map[0].length) return false;
        if (map[x][y] != 1) return false;
        return true;
    }
}
