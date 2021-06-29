package me.algo.week59;

import java.util.Arrays;

/**
 * Created by Bomi on 2021/06/29.
 * 문제 출처 : https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class Leet1689 {
    public int minPartitions(String n) {
        return Arrays.stream(n.split(""))
                .mapToInt(Integer::parseInt)
                .max().getAsInt();
    }
}
