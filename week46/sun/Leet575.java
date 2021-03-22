package me.algo.week46.sun;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2021/03/22.
 * 문제 출처 : https://leetcode.com/problems/distribute-candies/
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Set(HashSet), Array
 */

public class Leet575 {
    public int distributeCandies(int[] candyType) {
        return Math.min(Arrays.stream(candyType).boxed().collect(Collectors.toSet()).size(), candyType.length / 2);
    }
}
