package me.algo.week17;

import java.io.*;
import java.util.*;

/**
 * Created by Bomi on 2020/09/17.
 * 문제 출처 : https://www.acmicpc.net/problem/1302
 *
 * Time Complexity : O(N)
 * Used Algorithm : Sort
 * Used Data structure : Array
 */

public class Main_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] bookNames = new String[n];
        for (int i = 0; i < n; i++) {
            bookNames[i] = br.readLine();
        }
        Arrays.sort(bookNames);

        String bestseller = bookNames[0];
        int count = 1, max = 1;
        for (int i = 1; i < n; i++) {
            if (bookNames[i - 1].equals(bookNames[i])) {
                if (++count > max) {
                    max = count;
                    bestseller = bookNames[i - 1];
                }
                continue;
            }
            count = 1;
        }
        System.out.println(bestseller);
    }
}
