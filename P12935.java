package me.algo;

import java.util.Arrays;

/**
 * Created by Bomi on 2021/06/25.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12935
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class P12935 {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{-1};

        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr).filter(it -> it != min).toArray();
    }
}
