package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * Created by Bomi on 2020/08/28.
 * 문제 출처 : https://www.acmicpc.net/problem/13300
 *
 * Time Complexity : O(N)
 * Used Algorithm : Implementation
 * Used Data structure : Array
 */

public class Main_13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] grades = new int[2][7];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            grades[parseInt(st.nextToken())][parseInt(st.nextToken())]++;
        }

        int rooms = 0;
        for(int i=1; i<7; i++) {
            rooms += grades[0][i] / k;
            if(grades[0][i] % k != 0) rooms++;

            rooms += grades[1][i] / k;
            if(grades[1][i] % k != 0) rooms++;
        }
        System.out.println(rooms);
    }
}
