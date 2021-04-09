package me.algo.week48.sun;

import java.util.Arrays;

/**
 * Created by Bomi on 2021/04/09.
 * 문제 출처 : https://leetcode.com/problems/reordered-power-of-2/
 *
 * Time Complexity :
 * Used Algorithm : Math
 * Used Data structure : Array
 */

public class Leet869 {
    public boolean reorderedPowerOf2(int n) {
        int[] nCounts = toCountArray(n);
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(nCounts, toCountArray(1 << i))) return true;
        }
        return false;
    }

    private int[] toCountArray(int n) {
        int[] counts = new int[10];
        while (n != 0) {
            counts[n % 10]++;
            n /= 10;
        }
        return counts;
    }
}
