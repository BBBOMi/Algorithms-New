package me.algo.week22;

/**
 * Created by Bomi on 2020/10/16.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/43165
 *
 * Time Complexity : O(logN)
 * Used Algorithm : DFS
 * Used Data structure : Array
 */

public class P43165 {
    public int solution(int[] numbers, int target) {
        return solution(numbers, target, 0, 0);
    }

    private int solution(int[] numbers, int target, int result, int index) {
        if (index == numbers.length) return result == target ? 1 : 0;

        return solution(numbers, target, result + numbers[index], index + 1)
                + solution(numbers, target, result - numbers[index], index + 1);
    }
}
