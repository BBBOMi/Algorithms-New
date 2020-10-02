package me.algo.week20;

import java.util.*;

/**
 * Created by Bomi on 2020/10/02.
 * 문제 출처 : https://www.hackerrank.com/challenges/minimum-loss/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : greedy
 * Used Data structure : TreeSet, Array
 */

public class MinimumLoss {
    static int minimumLoss(long[] price) {
        TreeSet<Long> treeSet = new TreeSet<>();
        treeSet.add(price[0]);
        long min = Long.MAX_VALUE;
        for (int i = 1; i < price.length; i++) {
            long value = price[i];
            Long higher = treeSet.higher(value);
            if (higher != null) {
                min = Math.min(min, Math.abs(higher - value));
            }
            treeSet.add(value);
        }
        return (int)min;
    }
}
