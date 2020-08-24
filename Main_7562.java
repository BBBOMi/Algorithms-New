package me.algo;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/24.
 * 문제 출처 : https://www.acmicpc.net/problem/7562
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Queue(LinkedList), Array
 */

public class Main_7562 {
    static class Pair {
        int x, y;
        int value;

        Pair(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    private static boolean[][] map;
    private static int[][] direction = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int length = Integer.parseInt(br.readLine());
            map = new boolean[length][length];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentX = Integer.parseInt(st.nextToken());
            int currentY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int arrivedX = Integer.parseInt(st.nextToken());
            int arrivedY = Integer.parseInt(st.nextToken());

            bw.write(countMoving(currentX, currentY, arrivedX, arrivedY) + "\n");
        }
        bw.close();
    }

    private static int countMoving(int fromX, int fromY, int toX, int toY) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(fromX, fromY, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.x == toX && current.y == toY) return current.value;

            for (int i = 0; i < 8; i++) {
                int nextX = current.x + direction[i][0];
                int nextY = current.y + direction[i][1];

                if(!isTillable(nextX, nextY)) continue;

                map[nextX][nextY] = true;
                queue.offer(new Pair(nextX, nextY, current.value + 1));
            }
        }
        return -1;
    }

    private static boolean isTillable(int x, int y) {
        if (x < 0 || x >= map.length || y < 0 || y >= map.length) return false;
        if(map[x][y]) return false;
        return true;
    }
}
