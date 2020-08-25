package me.algo.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Bomi on 2020/08/25.
 * 문제 출처 : https://www.acmicpc.net/problem/2217
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy, Sort
 * Used Data structure : Array
 */

public class Main_2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];

        for(int i=0; i<n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);
        int max = ropes[0] * n;
        for(int i=1; i<n; i++) {
            int temp = ropes[i] * (n - i);
            if(max < temp) max = temp;
        }
        System.out.println(max);
    }
}
