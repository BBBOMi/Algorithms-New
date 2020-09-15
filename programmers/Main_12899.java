package me.algo.programmers;

/**
 * Created by Bomi on 2020/09/16.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12899
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : Array
 */

public class Main_12899 {
    public String solution(int n) {
        final String[] NUMBERS = {"4", "1", "2"};
        String answer = "";
        while (n > 0) {
            answer = NUMBERS[n%3] + answer;
            n = (n-1) / 3;
        }
        return answer;
    }
}
