package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bomi on 2020/07/28.
 * 문제 출처 : https://leetcode.com/problems/combination-sum/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Backtracking
 * Used Data structure : List(ArrayList), Array
 */

public class Main_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        fillTheResult(candidates, target, result, new ArrayList(), 0);
        return result;
    }

    private static void fillTheResult(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int start) {
        int sum = list.stream().reduce(0, Integer::sum);
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            sum += candidates[i];
            if(sum > target) return;

            list.add(candidates[i]);
            fillTheResult(candidates, target, result, list, i);
            list.remove(list.size() - 1);
            sum -= candidates[i];
        }
    }
}
