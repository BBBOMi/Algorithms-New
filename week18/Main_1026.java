package me.algo.week18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/09/20.
 * 문제 출처 : https://www.acmicpc.net/problem/1026
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Sort
 * Used Data structure : Array
 */

public class Main_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);

        int s = 0;
        for (int i = 0; i < n; i++) {
            s += a[i] * maxValue(b);
        }

        System.out.println(s);
    }

    private static int maxValue(int[] b) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < b.length; i++) {
            if (max < b[i]) {
                max = b[i];
                index = i;
            }
        }
        b[index] = -1;
        return max;
    }
}
