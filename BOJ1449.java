package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/11/11.
 * 문제 출처 : https://www.acmicpc.net/problem/1449
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class BOJ1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] holes = new int[n];
        for (int i = 0; i < n; i++) {
            holes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(holes);
        int count = 1;
        int preHole = holes[0];
        for (int i = 1; i < n; i++) {
            if (holes[i] - preHole <= l - 1) continue;
            count++;
            preHole = holes[i];
        }

        System.out.println(count);
    }
}
