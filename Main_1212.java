package me.algo;

import java.io.*;

/**
 * Created by Bomi on 2020/08/27.
 * 문제 출처 : https://www.acmicpc.net/problem/1212
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math, Implementation
 * Used Data structure : Array
 */

public class Main_1212 {
    private static final String[] EIGHT = {"000", "001", "010", "011", "100", "101", "110", "111"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(toBinaryString(br.readLine()));
    }

    private static String toBinaryString(String octal) {
        if (octal.length() == 1 && octal.charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();
        int i = appendFirst(octal, 0, sb);
        for (int len = octal.length(); i < len; i++) {
            int n = octal.charAt(i) - '0';
            sb.append(EIGHT[n]);
        }
        return sb.toString();
    }

    private static int appendFirst(String octal, int index, StringBuilder sb) {
        int first = octal.charAt(index) - '0';
        if(first > 3) return index;
        if(first == 0) return ++index;
        sb.append(Integer.toBinaryString(first));
        return ++index;
    }
}
