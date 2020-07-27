package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/07/28.
 * 문제 출처 : https://www.acmicpc.net/problem/11005
 *
 * Time Complexity : O(N)
 * Used Algorithm : 문자열
 */

public class Main_11005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int mod = n % b;
            if(mod < 10) {
                sb.append(mod);
            } else {
                sb.append((char)(mod + 55));
            }
            n /= b;
        }
        System.out.println(sb.reverse().toString());
    }
}
