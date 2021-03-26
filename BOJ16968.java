package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2021/03/26.
 * 문제 출처 : https://www.acmicpc.net/problem/16968
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 */

public class BOJ16968 {
    private static final int NUMBER_COUNT = 10;
    private static final int CHARACTER_COUNT = 26;

    private static final char POSITION_CHARACTER = 'c';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String format = br.readLine();

        int count = format.charAt(0) == POSITION_CHARACTER ? CHARACTER_COUNT : NUMBER_COUNT;
        for (int i = 1, length = format.length(); i < length; i++) {
            char currentPosition = format.charAt(i);
            if (currentPosition == POSITION_CHARACTER)
                count = multiply(count, CHARACTER_COUNT, currentPosition == format.charAt(i - 1));
            else count = multiply(count, NUMBER_COUNT, currentPosition == format.charAt(i - 1));
        }
        System.out.println(count);
    }

    private static int multiply(int count, int multiplier, boolean sameWithPrePosition) {
        return sameWithPrePosition ? count * (multiplier - 1) : count * multiplier;
    }

}
