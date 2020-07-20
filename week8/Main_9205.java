package me.algo.week8;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/07/17.
 * 문제 출처 : https://www.acmicpc.net/problem/9205
 *
 * Time Complexity : O(N ^ 3)
 * Used Algorithm : Floyd-Warshall(모든 최단 경로를 구함)
 * Used Data structure : Array
 */

public class Main_9205 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Point(String point) {
            StringTokenizer st = new StringTokenizer(point);
            this.x = Integer.parseInt(st.nextToken());
            this.y = Integer.parseInt(st.nextToken());
        }
    }

    private static final int MAX_DISTANCE = 20 * 50;
    private static final String HAPPY = "happy";
    private static final String SAD = "sad";

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(getEmotion(n) + "\n");
        }
        bw.close();
    }

    private static int[][] setArray(int count) throws IOException {
        Point[] points = new Point[count];
        for(int i=0; i<count; i++) {
            points[i] = new Point(br.readLine());
        }

        int[][] map = new int[count][count];
        for(int[] arr : map) {
            Arrays.fill(arr, count);
        }

        for(int i=0; i<count; i++) {
            for (int j=0; j<count; j++) {
                if(i == j) continue;

                int distance = calculateDistance(points[i], points[j]);
                map[i][j] = isHappy(distance) ? 1 : map[i][j];
            }
        }
        return map;
    }

    private static String getEmotion(int n) throws IOException {
        int totalCount = n+2;
        int[][] map = setArray(totalCount);

        floyd(map, totalCount);

        if(0 < map[0][n+1] && map[0][n+1] < totalCount) {
            return HAPPY;
        }
        return SAD;
    }

    private static void floyd(int[][] arr, int n) {
        // k -> 거쳐가는 정점
        // i -> 출발하는 정점
        // j -> 도착하는 정점
        for(int k=0; k<n; k++ ) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
    }

    private static boolean isHappy(int distance) {
        return distance <= MAX_DISTANCE;
    }

    private static int calculateDistance(Point current, Point next) {
        return  getPointX(current, next) + getPointY(current, next);
    }

    private static int getPointX(Point current, Point next) {
        return Math.abs(next.x - current.x);
    }

    private static int getPointY(Point current, Point next) {
        return Math.abs(next.y - current.y);
    }
}
