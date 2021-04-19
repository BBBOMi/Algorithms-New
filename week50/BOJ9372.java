package me.algo.week50;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2021/04/19.
 * 문제 출처 : https://www.acmicpc.net/problem/9372
 *
 * Time Complexity : O(N)
 * Used Algorithm : MST
 */

public class BOJ9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            while (m-- > 0) {
                br.readLine();
            }
            bw.write(n - 1 + "\n");
        }
        bw.close();
    }
}
