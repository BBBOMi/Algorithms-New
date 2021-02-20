package me.algo.week40.sun;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bomi on 2021/02/20.
 * 문제 출처 : https://leetcode.com/problems/longest-harmonious-subsequence/
 * <p>
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : Map(HashMap)
 */

public class Leet594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (!map.containsKey(num - 1) && !map.containsKey(num + 1)) continue;
            int maxSubSequenceLength = Math.max(
                    map.getOrDefault(num - 1, 0),
                    map.getOrDefault(num + 1, 0)) + map.get(num);

            result = Math.max(result, maxSubSequenceLength);
        }
        return result;
    }
}
