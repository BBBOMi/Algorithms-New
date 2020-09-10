package me.algo.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bomi on 2020/09/10.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/1829
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS, DFS
 * Used Data structure : Array, Queue(LinkedList)
 */

public class Main_1829 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]) continue;
                if (picture[i][j] != 0) {
                    int area = countArea(i, j, picture, visited);
                    if(area > maxSizeOfOneArea) maxSizeOfOneArea = area;
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    private static int countArea(int x, int y, int[][] picture, boolean[][] visited) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            count++;

            for(int i=0; i<4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextX >= picture.length || nextY < 0 || nextY >= picture[0].length)
                    continue;
                if(visited[nextX][nextY])
                    continue;
                if(picture[nextX][nextY] != picture[current.x][current.y])
                    continue;

                queue.offer(new Point(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }
        return count;
    }
}
