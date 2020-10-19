package me.algo.programmers;

/**
 * Created by Bomi on 2020/10/19.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12909
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class P12909 {
    boolean solution(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                continue;
            }
            if(--count < 0) return false;
        }
        return count == 0;
    }
}
