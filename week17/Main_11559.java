package me.algo.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2020/09/16.
 * 문제 출처 : https://www.acmicpc.net/problem/11559
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : BFS
 * Used Data structure : Array, List(ArrayList)
 */

public class Main_11559 {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static char[][] board;

    private static final int HEIGHT = 12;
    private static final int WIDTH = 6;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            board[i] = br.readLine().toCharArray();
        }
        System.out.println(countCombo());
    }

    private static int countCombo() {
        int combo = 0;
        while (true) {
            boolean isPop = false;
            boolean[][] visited = new boolean[HEIGHT][WIDTH];
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    if (visited[i][j]) continue;
                    if (board[i][j] == '.') continue;

                    if (popBlocks(visited, i, j)) isPop = true;
                }
            }
            if (!isPop) return combo;
            combo++;
            paint();
        }
    }

    private static boolean popBlocks(boolean[][] visited, int x, int y) {
        List<Point> points = getSameBlocks(visited, x, y);
        if (points.size() >= 4) {
            for (Point p : points) {
                board[p.x][p.y] = '.';
            }
        }
        return points.size() >= 4;
    }

    private static List<Point> getSameBlocks(boolean[][] visited, int x, int y) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(x, y));
        visited[x][y] = true;
        int index = -1;
        while (++index < points.size()) {
            Point current = points.get(index);

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX >= HEIGHT || nextY < 0 || nextY >= WIDTH)
                    continue;
                if (visited[nextX][nextY])
                    continue;
                if (board[x][y] != board[nextX][nextY])
                    continue;

                points.add(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }
        return points;
    }

    private static void paint() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = HEIGHT - 1; j >= 0; j--) {
                if (board[j][i] != '.') continue;
                for (int k = j - 1; k >= 0; k--) {
                    if (board[k][i] != '.') {
                        board[j][i] = board[k][i];
                        board[k][i] = '.';
                        break;
                    }
                }
            }
        }
    }

}
