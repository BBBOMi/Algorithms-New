package me.algo.week46.sun;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Bomi on 2021/03/25.
 * 문제 출처 : https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Tree
 * Used Data structure : Map(TreeMap), List(ArrayList)
 */

public class Leet637 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>(); // level, sum
        averageOfLevels(root, map, 0);

        List<Double> answer = new ArrayList<>();
        map.forEach((k, v) -> answer.add(average(v)));
        return answer;
    }

    private void averageOfLevels(TreeNode root, Map<Integer, List<Integer>> map, int level) {
        if (root == null) return;

        map.computeIfAbsent(level, value -> new ArrayList<>()).add(root.val);
        averageOfLevels(root.left, map, level + 1);
        averageOfLevels(root.right, map, level + 1);
    }

    private double average(List<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }
}
