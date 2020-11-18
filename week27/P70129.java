package me.algo.week27;

/**
 * Created by Bomi on 2020/11/18.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/70129
 *
 * Time Complexity : O(logN)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class P70129 {
    public int[] solution(String s) {
        int oneCount = 0, changeCount = 0;
        while (s.length() > 1) {
            String oneString = s.replaceAll("0", "");
            oneCount += s.length() - oneString.length();
            s = Integer.toBinaryString(oneString.length());
            changeCount++;
        }
        return new int[]{changeCount, oneCount};
    }
}
