package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2021/06/26.
 * 문제 출처 : https://www.acmicpc.net/problem/9655
 *
 * Time Complexity : O(1)
 * Used Algorithm : Math
 */

public class BOJ9665 {
    private static final String FIRST_PLAYER = "SK";
    private static final String SECOND_PLAYER = "CY";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(winner(n));
    }

    private static String winner(int stones) {
        return stones % 2 == 1 ? FIRST_PLAYER : SECOND_PLAYER;
    }
}
