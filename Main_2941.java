package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/08/28.
 * 문제 출처 : https://www.acmicpc.net/problem/2941
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class Main_2941 {
    private static String[] words = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for(int i=0; i<words.length; i++) {
            input = input.replaceAll(words[i], ".");
        }
        System.out.println(input.length());
    }
}
