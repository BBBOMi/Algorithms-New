package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/20.
 * 문제 출처 : https://www.acmicpc.net/problem/2675
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Implementation
 */

public class Main_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            result.append(makeRepeatString(Integer.parseInt(st.nextToken()), st.nextToken())).append("\n");
        }
        System.out.println(result.toString());
    }

    private static String makeRepeatString(int r, String s) {
        StringBuilder sb = new StringBuilder(s.length() * r);
        for(char c : s.toCharArray()) {
            for(int i=0; i<r; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
