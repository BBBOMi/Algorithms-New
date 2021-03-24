package me.algo.week46.sun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Bomi on 2021/03/24.
 * 문제 출처 : https://leetcode.com/problems/missing-number/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Set(HashSet), List(ArrayList), Array
 */

public class Leet268 {
    public int missingNumber(int[] nums) {
        Set<Integer> set = IntStream.rangeClosed(0, nums.length).boxed().collect(Collectors.toSet());
        Arrays.stream(nums).forEach(set::remove);
        return new ArrayList<>(set).get(0);
    }
}
