package me.algo.week29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/12/08.
 * 문제 출처 : https://www.acmicpc.net/problem/1439
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class BOJ1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(countChanges(str));
    }

    private static int countChanges(String str) {
        if (str.isEmpty()) return 0;

        int count = 0;
        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[0] == chars[i]) continue;
            i = getNextIndexAfterChanging(chars[0], chars, i);
            count++;
        }
        return count;
    }

    private static int getNextIndexAfterChanging(char standard, char[] chars, int fromIndex) {
        for (int i = fromIndex; i < chars.length; i++) {
            if(chars[i] == standard) return i;
            chars[i] = standard;
        }
        return chars.length;
    }
}
