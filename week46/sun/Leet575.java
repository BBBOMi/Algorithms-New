package me.algo.week46.sun;

import java.util.Arrays;

/**
 * Created by Bomi on 2021/03/22.
 * 문제 출처 : https://leetcode.com/problems/distribute-candies/
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Array
 */

public class Leet575 {
    public int distributeCandies(int[] candyType) {
        return (int) Math.min(Arrays.stream(candyType).distinct().count(), candyType.length / 2);
    }
}
