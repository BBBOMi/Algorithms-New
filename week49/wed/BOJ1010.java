package me.algo.week49.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/04/09.
 * 문제 출처 : https://www.acmicpc.net/problem/1010
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : 파스칼의 삼각형
 * Used Data structure : Array
 */

public class BOJ1010 {
    private static final int MAX_LENGTH = 30;
    private static int[][] combinations = new int[MAX_LENGTH][MAX_LENGTH];

    public static void main(String[] args) throws IOException {
        combination();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(combinations[n][m]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void combination() {
        for (int i = 0; i < MAX_LENGTH; i++) {
            combinations[0][i] = 1;
            combinations[i][i] = 1;
        }

        for (int i = 1; i < MAX_LENGTH; i++) {
            for (int j = 1; j < MAX_LENGTH; j++) {
                combinations[i][j] = combinations[i - 1][j - 1] + combinations[i][j - 1];
            }
        }
    }
}
