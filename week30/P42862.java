package me.algo.week30;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2020/12/10.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42862
 *
 * Time Complexity : O(N)
 * Used Algorithm : Greedy
 * Used Data structure : Set
 */

public class P42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        Set<Integer> reserveSet = Arrays.stream(reserve).boxed().collect(Collectors.toSet());

        lostSet.removeAll(reserveSet);
        reserveSet.removeAll(Arrays.stream(lost).boxed().collect(Collectors.toSet()));

        int student = n;
        for (int l : lostSet) {
            if (reserveSet.remove(l - 1)) continue;
            else if (reserveSet.remove(l + 1)) continue;
            student--;
        }
        return student;
    }
}
