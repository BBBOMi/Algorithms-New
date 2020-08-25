package me.algo.week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/08/25.
 * 문제 출처 : https://www.acmicpc.net/problem/10162
 *
 * Time Complexity : O(1)
 * Used Algorithm : Math, Implementation
 */

public class Main_10162 {
    private static final int BUTTON_C = 10;
    private static final int BUTTON_B = BUTTON_C * 6;
    private static final int BUTTON_A = BUTTON_B * 5;

    private static final int FAIL = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        if(t % BUTTON_C != 0) {
            System.out.println(FAIL);
            return;
        }

        int countA=0, countB=0, countC=0;
        countA = t / BUTTON_A;
        t %= BUTTON_A;
        countB = t / BUTTON_B;
        t %= BUTTON_B;
        countC = t / BUTTON_C;

        System.out.println(countA + " " + countB + " " + countC);
    }
}
