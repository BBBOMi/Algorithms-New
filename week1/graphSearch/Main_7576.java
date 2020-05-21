package me.algo.week1.graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/05/21.
 * 문제 출처 : https://www.acmicpc.net/problem/7576
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Queue(LinkedList), Array
 */

public class Main_7576 {
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    private static int m;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] tomatoes = new int[n][m];
        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    queue.offer(new Node(i, j));
                }
            }
        }

        System.out.println(countDays(tomatoes, queue));
    }

    private static int countDays(int[][] arr, Queue<Node> queue) {
        int count = 0;
        while (!queue.isEmpty()) {
            Node point = queue.poll();
            count = point.day;

            for (int i = 0; i < 4; i++) {
                int nextX = point.x + dx[i];
                int nextY = point.y + dy[i];

                if(isUnvisitable(nextX, nextY, arr)) {
                    continue;
                }

                queue.offer(new Node(nextX, nextY, count + 1));
                arr[nextX][nextY] = count + 1;
            }
        }

        return isExistedZero(arr) ? -1 : count;
    }

    private static boolean isUnvisitable(int x, int y, int[][] arr) {
        if (x < 0 || x >= n)
            return true;

        if(y < 0 || y >= m) {
            return true;
        }

        if (arr[x][y] != 0) {
            return true;
        }
        return false;
    }

    private static boolean isExistedZero(int[][] arr) {
        for (int[] line : arr) {
            for (int dayCount : line) {
                if (dayCount == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Node {
    int x;
    int y;
    int day;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
        this.day = 0;
    }

    Node(int x, int y, int day) {
        this(x, y);
        this.day = day;
    }
}
