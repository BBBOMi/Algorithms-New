package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/09/13.
 * 문제 출처 : https://www.acmicpc.net/problem/1541
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : Array
 */

public class Main_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] sum = input.split("-");
        int result = 0;
        for(int i=0; i<sum.length; i++) {
            String[] numbers = sum[i].split("\\+");

            int temp = 0;
            for(String number : numbers) {
                temp += Integer.parseInt(number);
            }

            if(i == 0) temp *= -1;

            result -= temp;
        }

        System.out.println(result);
    }
}
