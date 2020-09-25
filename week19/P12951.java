package me.algo.week19;

/**
 * Created by Bomi on 2020/09/25.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12951
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class P12951 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        s = s.toLowerCase();
        boolean isFront = true;
        for (char ch : s.toCharArray()) {
            ch = isFront ? Character.toUpperCase(ch) : ch;
            isFront = ch == ' ';
            sb.append(ch);
        }
        return sb.toString();
    }
}
