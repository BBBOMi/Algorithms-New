package me.algo.week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/12/07.
 * 문제 출처 : https://www.acmicpc.net/problem/7568
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Brute-force
 * Used Data structure : Array
 */

public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] weightsAndHeights = new int[2][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            weightsAndHeights[0][i] = Integer.parseInt(st.nextToken());
            weightsAndHeights[1][i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getRanking(n, weightsAndHeights));
    }

    private static String getRanking(int n, int[][] weightsAndHeights) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (weightsAndHeights[0][i] >= weightsAndHeights[0][j]) continue;
                if (weightsAndHeights[1][i] >= weightsAndHeights[1][j]) continue;
                rank++;
            }
            sb.append(rank).append(" ");
        }
        return sb.toString();
    }
}
