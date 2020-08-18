package me.algo;

import java.io.*;

/**
 * Created by Bomi on 2020/08/18.
 * 문제 출처 : https://www.acmicpc.net/problem/2577
 *
 * Time Complexity : O(N)
 * Used Algorithm : implementation
 * Used Data structure : Array
 */

public class Main_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String multiply = String.valueOf(a * b * c);
        int[] numbers = new int[10];
        for(char ch : multiply.toCharArray()) {
            numbers[ch - '0']++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int num : numbers) {
            bw.write(num + "\n");
        }
        bw.close();
    }
}
