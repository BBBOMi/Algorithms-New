package me.algo.week40.thu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2021/02/17.
 * 문제 출처 : https://www.acmicpc.net/problem/1436
 *
 * Time Complexity : O(N)
 * Used Algorithm : Brute-force
 */

public class BOJ1436 {
    private static final String END_NUMBER = "666";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(nthMovieTitle(n));
    }

    static Integer nthMovieTitle(int n) {
        int title = Integer.parseInt(END_NUMBER);
        int count = 1;
        while (count != n) {
            String stringTitle = String.valueOf(++title);
            if (stringTitle.contains(END_NUMBER)) count++;
        }
        return title;
    }
}

