package me.algo.week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/09/17.
 * 문제 출처 : https://www.acmicpc.net/problem/1080
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class Main_1080 {
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] A = new char[n][m];
        for (int i = 0; i < n; i++) {
            A[i] = br.readLine().toCharArray();
        }

        char[][] B = new char[n][m];
        for (int i = 0; i < n; i++) {
            B[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == B[i][j]) continue;
                reverse(A, i, j);
            }
        }
        System.out.println(Arrays.deepEquals(A, B) ? count : -1);
    }

    private static void reverse(char[][] A, int x, int y) {
        if (x + 2 >= A.length || y + 2 >= A[0].length) return;
        count++;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (A[i][j] == '0') A[i][j] = '1';
                else A[i][j] = '0';
            }
        }
    }
}
