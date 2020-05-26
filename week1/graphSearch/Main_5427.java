package me.algo.week1.graphSearch;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/05/25.
 * 문제 출처 : https://www.acmicpc.net/problem/5427
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Array, Queue(LinkedList)
 */

public class Main_5427 {
    static class Node {
        int x;
        int y;
        int count;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Node(int x, int y, int count) {
            this(x, y);
            this.count = count;
        }
    }

    private static int w, h;
    private static char[][] map;
    private static Queue<Node> queue;

    private static Node startPoint;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    private final static String IMPOSSIBLE = "IMPOSSIBLE";

    private static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            makeMap(h, w);
            int result = bfs();
            bw.write(result != -1 ? result + "\n" : IMPOSSIBLE + "\n");
        }
        bw.close();
    }

    private static void makeMap(int h, int w) throws IOException {
        map = new char[h][w];
        queue = new LinkedList<>();
        for(int i=0; i<h; i++) {
            String line = br.readLine();
            for(int j=0; j<w; j++) {
                map[i][j] = line.charAt(j);
                enQueue(i, j);
            }
        }
        queue.offer(startPoint);
    }

    private static void enQueue(int i, int j) {
        switch (map[i][j]) {
            case '#': case '.':
                return;

            case '@':
                startPoint = new Node(i, j);
                return;

            default:
                queue.offer(new Node(i, j));
        }
    }

    private static int bfs() {
        int count = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x;
            int y = node.y;
            count = node.count;

            if(isEscape(node)) return ++count;

            for(int i=0; i<4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(!isAvailable(nextX, nextY)) {
                    continue;
                }

                Node newNode = new Node(nextX, nextY);
                newNode.count = map[x][y] == '@' ? count+1 : 0;
                map[nextX][nextY] = map[x][y];
                queue.offer(newNode);
            }
        }
        return -1;
    }

    private static boolean isEscape(Node node) {
        if(!isCorrectIndex(node.x, node.y)) return false;
        if(map[node.x][node.y] != '@') return false;
        if(node.x == 0 || node.x == h-1) return true;
        if(node.y == 0 || node.y == w-1) return true;
        return false;
    }

    private static boolean isCorrectIndex(int x, int y) {
        if(0 > x || x >= h) return false;
        if(0 > y || y >= w) return false;
        return true;
    }

    private static boolean isAvailable(int x, int y) {
        if(!isCorrectIndex(x, y)) return false;
        if(map[x][y] == '.') return true;
        return false;
    }
}
