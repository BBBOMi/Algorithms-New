package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/08/14.
 * 문제 출처 : https://www.acmicpc.net/problem/2292
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math, Implementation
 */

public class Main_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(countEnteredRooms(n));
    }

    private static int countEnteredRooms(long n) {
        int step = 1;
        int arrange = 1;
        while (arrange < n) {
            arrange += (step++) * 6;
        }
        return step;
    }
}
