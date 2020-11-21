package me.algo.week27;

/**
 * Created by Bomi on 2020/11/21.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/68935
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 */

public class P68935 {
    private static final int TERNARY = 3;
//
    // 문제를 그대로 표현한 코드
//    public int solution(int n) {
//        String reverseTernary = new StringBuilder(Integer.toString(n, TERNARY))
//                .reverse().toString();
//        return convertToDecimal(reverseTernary);
//    }
//
//    private int convertToDecimal(String ternaryString) {
//        final int DECIMAL = 10;
//
//        int result = 0;
//        for (int digit = 0, i = ternaryString.length() - 1; i >= 0; digit++, i--) {
//            result += Character.digit(ternaryString.charAt(i), DECIMAL) * Math.pow(TERNARY, digit);
//        }
//        return result;
//    }

    // reverse 하는 과정이 불필요해 보여 제거 - 더 빠름!
    public int solution(int n) {
        String reverseTernary = Integer.toString(n, TERNARY);
        return convertToDecimal(reverseTernary);
    }

    private int convertToDecimal(String ternaryString) {
        final int DECIMAL = 10;
        final int LENGTH = ternaryString.length();

        int result = 0;
        for (int digit = 0, i = 0; i < LENGTH; digit++, i++) {
            result += Character.digit(ternaryString.charAt(i), DECIMAL) * Math.pow(TERNARY, digit);
        }
        return result;
    }
}
