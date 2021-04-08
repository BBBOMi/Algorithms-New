package me.algo.week49.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/04/08.
 * 문제 출처 : https://www.acmicpc.net/problem/11051
 *
 * Time Complexity : O(N ^ 2)
 * Used Algorithm : Pascal's Triangle
 * Used Data structure : Array
 */

public class BOJ11051 {
    private static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] coefficients = new int[n + 1][k + 1];
        fillCoefficient(coefficients);
        System.out.println(coefficients[n][k]);
    }

    private static void fillCoefficient(int[][] coefficients) {
        final int HEIGHT = coefficients.length;
        final int WIDTH = coefficients[0].length;

        for (int i = 0; i < HEIGHT; i++) {
            coefficients[i][0] = 1;
            if (i < WIDTH) coefficients[i][i] = 1;
        }

        for (int i = 1; i < HEIGHT; i++) {
            for (int j = 1; j < WIDTH; j++) {
                coefficients[i][j] = (coefficients[i - 1][j - 1] + coefficients[i - 1][j]) % MOD;
            }
        }
    }
}
