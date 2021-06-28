package me.algo;

import java.util.Arrays;

/**
 * Created by Bomi on 2021/06/29.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12939
 *
 * Time Complexity : O(N log N)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class P12939 {
    public String solution(String s) {
        int[] numbers = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        return numbers[0] + " " + numbers[numbers.length - 1];
    }
}
