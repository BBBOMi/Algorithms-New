package me.algo.leetcode;

import java.util.*;

/**
 * Created by Bomi on 2020/10/08.
 * 문제 출처 : https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Graph(DFS, BFS)
 * Used Data structure : List(ArrayList), Queue(LinkedList), Set(HashSet), Map(HashMap)
 */

public class Leet863 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static Map<TreeNode, TreeNode> parents;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(target == null) return new ArrayList<>();
        parents = new HashMap<>();
        findParent(root, null);

        List<Integer> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;
        while (!queue.isEmpty() && distance <= K) { // BFS
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (distance == K) {
                    answer.add(current.val);
                    continue;
                }
                if (current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }
                if (current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }
                if (parents.get(current) != null && !visited.contains(parents.get(current))) {
                    queue.offer(parents.get(current));
                    visited.add(parents.get(current));
                }
            }
            distance++;
        }
        return answer;
    }

    // DFS
    public void findParent(TreeNode node, TreeNode parent) {
        if (node == null) return;
        parents.put(node, parent);
        findParent(node.left, node);
        findParent(node.right, node);
    }
}
