package me.algo.programmers;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/07/08.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42746
 *
 * Time Complexity : O(N)
 * Used Algorithm : sort
 * Used Data structure : Array
 */

public class Main_42746 {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((String s1, String s2) -> (s2+s1).compareTo(s1+s2))
                .forEach(s -> sb.append(s));
        if(sb.charAt(0) == '0') return "0";
        return sb.toString();
    }
}
