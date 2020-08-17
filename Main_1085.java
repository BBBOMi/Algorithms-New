package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

/**
 * Created by Bomi on 2020/08/17.
 * 문제 출처 : https://www.acmicpc.net/problem/1085
 *
 * Time Complexity : O(1)
 * Used Algorithm : Math
 */

public class Main_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        System.out.println(min(min(x, (w - x)), min(y, (h - y))));

    }
}
