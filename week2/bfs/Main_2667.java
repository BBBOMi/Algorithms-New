package me.algo.week2.bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Bomi on 2020/05/26.
 * 문제 출처 : https://www.acmicpc.net/problem/2667
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : BFS
 * Used Data structure : Array, List, Queue(LinkedList)
 */

public class Main_2667 {
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

    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0; i<n; i++) {
            String line = br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        list = new ArrayList<>();
        findDanzi();
        list.sort((e1, e2) -> e1 - e2);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(list.size()+ "\n");
        for(int element : list) {
            bw.write(element + "\n");
        }
        bw.close();
    }

    private static void findDanzi() {
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map.length; j++) {
                if(map[i][j] == 1) {
                    map[i][j] = 0;
                    bfs(new Node(i, j));
                }
            }
        }
    }

    private static void bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int count = 0;
        while (!queue.isEmpty()) {
            Node present = queue.poll();

            for(int i=0; i<4; i++) {
                int nextX = present.x + dx[i];
                int nextY = present.y + dy[i];

                if(!isAvailable(nextX, nextY))
                    continue;

                queue.offer(new Node(nextX, nextY));
                map[nextX][nextY] = 0;
                count++;
            }
        }
        list.add(++count);
    }

    private static boolean isAvailable(int x, int y) {
        int length = map.length;
        if(0 > x || x >= length || 0 > y || y >= length) return false;
        if(map[x][y] == 0) return false;
        return true;
    }
}
