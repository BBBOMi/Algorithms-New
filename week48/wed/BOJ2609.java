package me.algo.week48.wed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/04/02.
 * 문제 출처 : https://www.acmicpc.net/problem/2609
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 */

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }

    private static int gcd(int a, int b) {
        return (b > 0) ? gcd(b, a % b) : a;
    }

    private static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
