package me.algo.leetcode;

/**
 * Created by Bomi on 2020/08/03.
 * 문제 출처 : https://leetcode.com/problems/decode-string/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Recursion, String
 */

public class Main_394 {
    private static int index;

    public String decodeString(String s) {
        index = -1;
        return decode(s);
    }

    private static String decode(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (++index < s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                continue;
            }
            if (c == '[') {
                String exp = decode(s);
                for( ; num > 0; num--) {
                    sb.append(exp);
                }
                continue;
            }
            if (c == ']') {
                return sb.toString();
            }
            sb.append(c);
        }
       return sb.toString();
    }
}
