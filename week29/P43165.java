package me.algo.week29;

/**
 * Created by Bomi on 2020/12/03.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/43165
 *
 * Time Complexity : O(2^N)
 * Used Algorithm : DFS
 * Used Data structure : Array
 */

public class P43165 {
    public int solution(int[] numbers, int target) {
        return solution(numbers, target, 0, 0, true);
    }

    private int solution(int[] numbers, int target, int index, int result, boolean positive) {
        if (index >= numbers.length) return target == result ? 1 : 0;

        return solution(numbers, target, index + 1, result + numbers[index], true)
                + solution(numbers, target, index + 1, result - numbers[index], false);
    }
}
