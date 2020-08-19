package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/08/19.
 * 문제 출처 : https://www.acmicpc.net/problem/2231
 *
 * Time Complexity : O(N)
 * Used Algorithm : Brute-force
 */

public class Main_2231 {
    private static final int NO_CONSTRUCTOR_NUMBER = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(findConstructorNumber(n));
    }

    private static int findConstructorNumber(int n) {
        int cases = getDigit(n) * 9;
        int constructor = n - cases;
        for(int i=0; i<cases; i++, constructor++) {
            int start = constructor, sum = start;
            while (start > 0) {
                sum += start % 10;
                start /= 10;
            }
            if(sum == n) {
                return constructor;
            }
        }
        return NO_CONSTRUCTOR_NUMBER;
    }

    private static int getDigit(int n) {
         return (int)(Math.log10(n) + 1);
    }
}
