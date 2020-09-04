package me.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Bomi on 2020/09/03.
 * 문제 출처 : https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class Main_448 {
    // runtime - 49ms
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numbers = IntStream.rangeClosed(1, nums.length).boxed().collect(Collectors.toSet());
        Arrays.stream(nums).distinct().forEach(n -> numbers.remove(n));
        return new ArrayList<>(numbers);
    }

    // runtime - 3ms
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        boolean[] checked = new boolean[nums.length];
        for (int i : nums) {
            checked[i - 1] = true;
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!checked[i]) answer.add(i + 1);
        }
        return answer;
    }
}
