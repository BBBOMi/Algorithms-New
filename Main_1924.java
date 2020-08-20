package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/08/20.
 * 문제 출처 : https://www.acmicpc.net/problem/1924
 *
 * Time Complexity : O(N)
 * Used Algorithm : Implementation
 * Used Data structure : Array
 */

public class Main_1924 {
    private static final String[] DAY_OF_WEEK = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int term = day;
        for (int i = 1; i < month; i++) {
            switch (i) {
                case 2:
                    term += 28;
                    break;
                case 4: case 6: case 9: case 11:
                    term += 30;
                    break;
                default:
                    term += 31;
            }
        }
        System.out.println(DAY_OF_WEEK[(term - 1)%7]);
    }
}
