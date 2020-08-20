package me.algo;

import java.io.*;

/**
 * Created by Bomi on 2020/08/20.
 * 문제 출처 : https://www.acmicpc.net/problem/5639
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DFS
 */

public class Main_5639 {
    static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeNode tree = null;
        String value;
        while ((value = br.readLine()) != null && !value.isEmpty()) {
            tree = setTree(tree, Integer.parseInt(value));
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        printPostOrder(tree, bw);
        bw.close();
    }

    private static TreeNode setTree(TreeNode root, int value) {
        if(root == null) {
            return new TreeNode(value);
        }
        if(value < root.value)
            root.left = setTree(root.left, value);
        else
            root.right = setTree(root.right, value);
        return root;
    }

    private static void printPostOrder(TreeNode root, BufferedWriter bw) throws IOException {
        if(root == null) return;
        if(root.left != null) printPostOrder(root.left, bw);
        if(root.right != null) printPostOrder(root.right, bw);
        bw.write(root.value + "\n");
    }
}
