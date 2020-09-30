package me.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Bomi on 2020/09/30.
 * 문제 출처 : https://leetcode.com/problems/combination-sum-ii/
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Recursive, Backtracking
 * Used Data structure : Array, List(ArrayList)
 */

public class Leet40 {
    private List<List<Integer>> answer;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        answer = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(candidates, target, new ArrayList<>(), 0, 0);
        return answer;
    }

    private void combinationSum2(int[] candidates, int target, List<Integer> list, int sum, int index) {
        if (sum > target) return;
        if (sum == target) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            combinationSum2(candidates, target, list, sum + candidates[i], i + 1);
            list.remove(list.size() - 1);
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) i++;
        }
    }
}

