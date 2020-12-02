package me.algo.week28;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * Created by Bomi on 2020/12/02.
 * 문제 출처 : https://www.acmicpc.net/problem/9205
 *
 * Time Complexity : O(N^3)
 * Used Algorithm : Floyd-warshall
 * Used Data structure : Array
 */

public class BOJ9205 {
    static class Point {
        int x;
        int y;

        Point(String xString, String yString) {
            this.x = parseInt(xString);
            this.y = parseInt(yString);
        }
    }

    private static final int MAX_DISTANCE_WITH_BEER = 20 * 50;

    private static final String CAN_DRINK_BEER = "happy";
    private static final String CANT_DRINK_BEER = "sad";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = parseInt(br.readLine());
        while (t-- > 0) {
            int storeCount = parseInt(br.readLine());
            Point[] points = new Point[storeCount + 2];
            for (int i = 0; i < storeCount + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i] = new Point(st.nextToken(), st.nextToken());
            }
            bw.write(canGoWithBeer(storeCount + 2, points) ? CAN_DRINK_BEER : CANT_DRINK_BEER);
            bw.write("\n");
        }
        bw.close();
    }

    private static boolean canGoWithBeer(int pointCount, Point[] points) {
        int[][] map = new int[pointCount][pointCount];
        Arrays.stream(map).forEach((int[] m) -> Arrays.fill(m, pointCount));
        setMapRouteCanGo(pointCount, points, map);

        floyd(pointCount, map);

        return 0 < map[0][pointCount - 1] && map[0][pointCount - 1] < pointCount;
    }

    private static void floyd(int pointCount, int[][] map) {
        for (int via = 0; via < pointCount; via++) {
            for (int from = 0; from < pointCount; from++) {
                for (int to = 0; to < pointCount; to++) {
                    if (map[from][to] <= map[from][via] + map[via][to]) continue;
                    map[from][to] = map[from][via] + map[via][to];
                }
            }
        }
    }

    private static void setMapRouteCanGo(int pointCount, Point[] points, int[][] map) {
        for (int i = 0; i < pointCount; i++) {
            for (int j = 0; j < pointCount; j++) {
                if (i == j) continue;
                if (!canGo(points[i], points[j])) continue;
                map[i][j] = 1;
            }
        }
    }

    private static boolean canGo(Point from, Point to) {
        return Math.abs(from.x - to.x) + Math.abs(from.y - to.y) <= MAX_DISTANCE_WITH_BEER;
    }
}
