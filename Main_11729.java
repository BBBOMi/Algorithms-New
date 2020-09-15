package me.algo;

import java.io.*;

/**
 * Created by Bomi on 2020/09/15.
 * 문제 출처 : https://www.acmicpc.net/problem/11729
 *
 * Time Complexity : O(2^N)
 * Used Algorithm : Recursion
 */

public class Main_11729 {
    private static int count;
    private static StringBuilder routes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        routes = new StringBuilder();
        hanoi(n, 1, 2, 3);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(count + "\n");
        bw.write(routes.toString());
        bw.close();
    }

    private static void move(int from, int to) {
        count++;
        routes.append(from + " " + to + "\n");
    }

    private static void hanoi(int n, int from , int by, int to) {
        if(n == 1) {
            move(from, to);
            return;
        }

        hanoi(n-1, from, to, by);
        move(from, to);
        hanoi(n-1, by, from, to);
    }
}
