package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/15.
 * 문제 출처 : https://www.acmicpc.net/problem/2609
 *
 * Time Complexity : O(N)
 * Used Algorithm : 수학
 */

public class Main_2609b {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int g = gcd(a, b);
        System.out.println(g);
        System.out.println(a * b / g);
    }

    private static int gcd(int a, int b) {
        while(b > 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}
