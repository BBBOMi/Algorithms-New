package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/08/21.
 * 문제 출처 : https://www.acmicpc.net/problem/1076
 *
 * Time Complexity : O(N)
 * Used Algorithm : Implementation
 * Used Data structure : Array
 */

public class Main_1076 {
    private static final String[] COLORS
            = {"black", "brown", "red", "orange", "yellow","green", "blue", "violet", "grey", "white"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String resistance = "";
        for(int i=0; i<3; i++) {
            resistance += findColorIndex(br.readLine());
        }

        long ohm = Long.parseLong(resistance.substring(0, 2)) * ((int)Math.pow(10, resistance.charAt(2) - '0'));
        System.out.println(ohm);
    }

    private static int findColorIndex(String color) {
        for(int i=0; i<COLORS.length; i++) {
            if(color.equals(COLORS[i])) {
                return i;
            }
        }
        return -1;
    }
}
