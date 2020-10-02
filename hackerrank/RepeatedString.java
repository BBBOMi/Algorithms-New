package me.algo.hackerrank;

/**
 * Created by Bomi on 2020/10/02.
 * 문제 출처 : https://www.hackerrank.com/challenges/repeated-string/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 */

public class RepeatedString {
    static long repeatedString(String s, long n) {
        final int LENGTH = s.length();
        return countA(s, LENGTH) * (n / LENGTH) + countA(s, (int) (n % LENGTH));
    }

    private static long countA(String s, int length) {
        final String TO_FIND = "a";
        return length - s.substring(0, length).replaceAll(TO_FIND, "").length();
    }
}
