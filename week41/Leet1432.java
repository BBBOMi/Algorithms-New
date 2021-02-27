package me.algo.week41;

import java.util.function.Predicate;

/**
 * Created by Bomi on 2021/02/27.
 * 문제 출처 : https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 *
 * Time Complexity : O(log N)
 * Used Algorithm : 반복문
 */

public class Leet1432 {
    public int numberOfSteps(int num) {
        Predicate<Integer> isEven = (n) -> n % 2 == 0;

        int count = 0;
        while (num != 0) {
            if (isEven.test(num)) num /= 2;
            else num--;
            count++;
        }
        return count;
    }
}
