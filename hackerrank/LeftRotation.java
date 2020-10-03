package me.algo.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bomi on 2020/10/03.
 * 문제 출처 : https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : Array
 * Used Data structure : Array, List(ArrayList)
 */

public class LeftRotation {
    static int[] rotLeft(int[] a, int d) {
        List<Integer> result = new ArrayList<>();
        Arrays.stream(Arrays.copyOfRange(a, d, a.length)).forEach(result::add);
        Arrays.stream(Arrays.copyOfRange(a, 0, d)).forEach(result::add);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
