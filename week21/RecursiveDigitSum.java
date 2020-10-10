package me.algo.week21;

/**
 * Created by Bomi on 2020/10/10.
 * 문제 출처 : https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : Recursion
 * Used Data structure : Array
 */

public class RecursiveDigitSum {
    static int superDigit(String n, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k % 9; i++) {
            sb.append(n);
        }
        return superDigit(sb.toString());
    }

    static int superDigit(String p) {
        if (p.length() == 1) return Integer.parseInt(p);
        int sum = 0;
        for (char c : p.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return superDigit(String.valueOf(sum));
    }
}
