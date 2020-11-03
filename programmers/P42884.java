package me.algo.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Bomi on 2020/11/02.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42884
 *
 * Time Complexity : O(N logN)
 * Used Algorithm : Greedy
 * Used Data structure : Array
 */

public class P42884 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt((int[] a) -> a[1]));
        int answer = 0;
        int lastCamera = Integer.MIN_VALUE;
        for (int[] a : routes) {
            if (lastCamera >= a[0]) continue;
            answer++;
            lastCamera = a[1];
        }
        return answer;
    }
}
