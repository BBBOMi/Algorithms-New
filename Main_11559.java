package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Bomi on 2020/08/25.
 * 문제 출처 : https://www.acmicpc.net/problem/11559
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Array
 */

public class Main_11559 {
    private static final int HEIGHT = 12;
    private static final int WIDTH = 6;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static char[][] board;
    private static boolean[][] visited;

    static class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new char[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            String[] chars = br.readLine().split("");
            for (int j = 0; j < WIDTH; j++) {
                board[i][j] = chars[j].charAt(0);
            }
        }
        System.out.println(getCombo());
    }

    private static int getCombo() {
        int combo = 0;
        while (true) {
            boolean isPop = false;
            visited = new boolean[HEIGHT][WIDTH];

            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    if (visited[i][j]) continue;
                    if (board[i][j] != '.') {
                        isPop = popPuyos(i, j);
                    }
                }
            }
            if (!isPop) return combo;
            combo++;
        }
    }

    private static boolean popPuyos(int x, int y) {
        List<Pair> points = getPoints(x, y);
        if (points.size() < 4) return false;

        for (Pair p : points) {
            board[p.x][p.y] = '.';
        }
        paint();
        return true;
    }


    private static List<Pair> getPoints(int x, int y) {
        List<Pair> points = new ArrayList<>();
        visited[x][y] = true;
        points.add(new Pair(x, y));

        int idx = -1;
        while (++idx < points.size()) {
            Pair current = points.get(idx);
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextX >= HEIGHT || nextY < 0 || nextY >= WIDTH) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                if (board[nextX][nextY] != board[current.x][current.y]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                points.add(new Pair(nextX, nextY));
            }
        }
        return points;
    }

    private static void paint() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = HEIGHT - 2; j >= 0; j--) {
                for (int k = HEIGHT - 1; k > j; k--) {
                    if (board[j][i] == '.') continue;
                    if (board[k][i] == '.') {
                        board[k][i] = board[j][i];
                        board[j][i] = '.';
                        break;
                    }
                }
            }
        }
    }
}
