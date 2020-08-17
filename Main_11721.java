package me.algo;

import java.io.*;

/**
 * Created by Bomi on 2020/08/17.
 * 문제 출처 : https://www.acmicpc.net/problem/11721
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 */

public class Main_11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        printTenLength(input);
    }

    private static void printTenLength(String str) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = str.length();
        int remainLength = length;
        int from = 0, to = 0;
        while(remainLength > 0) {
            from = to;
            to = (to + 10) < length ? to + 10 : length;
            remainLength -= (to - from);
            bw.write(str.substring(from, to) + "\n");
        }
        bw.close();
    }
}
