package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Bomi on 2020/08/18.
 * 문제 출처 : https://www.acmicpc.net/problem/1427
 *
 * Time Complexity : O(N)
 * Used Algorithm : Sort
 * Used Data structure : Array
 */

public class Main_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n = br.readLine();
        System.out.println(printReverse(n.toCharArray()));
    }

    private static String printReverse(char[] chars) {
        Arrays.sort(chars);
        StringBuilder sb = new StringBuilder(chars.length);
        for(int i=chars.length-1; i>=0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
