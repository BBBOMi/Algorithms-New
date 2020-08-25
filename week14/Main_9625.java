package me.algo.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/08/25.
 * 문제 출처 : https://www.acmicpc.net/problem/9625
 *
 * Time Complexity : O(N)
 * Used Algorithm : DP
 * Used Data structure : Array
 */

public class Main_9625 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] fibonacci = fibonacci(k);
        System.out.println(fibonacci[k+1] - fibonacci[k] + " " + fibonacci[k]);
    }

    private static int[] fibonacci(int k) {
        int[] arr = new int[k+2];
        arr[1] = 1;
        for(int i=2; i<=(k+1); i++) {
            arr[i] = arr[i-2] + arr[i-1];
        }
        return arr;
    }
}
