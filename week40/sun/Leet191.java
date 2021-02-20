package me.algo.week40.sun;

/**
 * Created by Bomi on 2021/02/20.
 * 문제 출처 : https://leetcode.com/problems/number-of-1-bits/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Bit
 */

public class Leet191 {
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
