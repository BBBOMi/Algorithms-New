package me.algo.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/09/04.
 * 문제 출처 : https://www.acmicpc.net/problem/2941
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 */

public class Main_2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(countAlphabet(str + " "));
    }

    private static int countAlphabet(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case ' ':
                    return count;

                case 'c':
                    if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') continue;
                    break;

                case 'd':
                    if (str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') continue;
                    if (str.charAt(i + 1) == '-') continue;
                    break;

                case 'l':
                case 'n':
                    if (str.charAt(i + 1) == 'j') continue;
                    break;

                case 's':
                case 'z':
                    if (str.charAt(i + 1) == '=') continue;
            }
            count++;
        }
        return count;
    }
}
