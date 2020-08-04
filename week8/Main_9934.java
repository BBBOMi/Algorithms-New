package me.algo.week8;

import java.io.*;
import java.util.*;

/**
 * Created by Bomi on 2020/07/16.
 * 문제 출처 : https://www.acmicpc.net/problem/9934
 *
 * Time Complexity : O(logN)
 * Used Algorithm : BST
 * Used Data structure : Map(TreeMap), List(ArrayList)
 */

public class Main_9934 {
//    static class Node {
//        Node left;
//        Node right;
//
//        Node() {
//            this.left = null;
//            this.right = null;
//        }
//    }
    private static int k;
    private static int index = 0;
    private static Map<Integer, List<Integer>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        int length = (int)Math.pow(2, k);

        int[] numbers = new int[length];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; st.hasMoreTokens(); i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

//        Node root = new Node();
//        setTree(root,0);
        map = new TreeMap<>();
//        setValues(root, 0, numbers);
        traversal(0, numbers);
        printValues();
    }

    private static void traversal(int depth, int[] numbers) {
        if(depth == k) return;

        traversal(depth + 1, numbers);
        List<Integer> values = map.getOrDefault(depth, new ArrayList<>());
        values.add(numbers[index++]);
        map.put(depth, values);
        traversal(depth + 1, numbers);
    }

    private static void printValues() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(List<Integer> value : map.values()) {
            for(int v : value) {
                bw.write(v + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }

//    private static void setTree(Node node, int depth) {
//        if(depth == k - 1) return;
//
//        node.left = new Node();
//        node.right = new Node();
//
//        setTree(node.left, depth + 1);
//        setTree(node.right, depth + 1);
//    }

//    private static void traversal(Node node, int depth, int[] numbers) {
//        if(depth == k) return;
//        node.left = new Node();
//        set(node.left, depth + 1, numbers);
//        List<Integer> values = map.getOrDefault(depth, new ArrayList<>());
//        values.add(numbers[index++]);
//        map.put(depth, values);
//        node.right = new Node();
//        set(node.right, depth + 1, numbers);
//    }



//    private static void setValues(Node node, int depth, int[] numbers) {
//        if(node != null) {
//            setValues(node.left, depth + 1, numbers);
//            List<Integer> values = map.getOrDefault(depth, new ArrayList<>());
//            values.add(numbers[index++]);
//            map.put(depth, values);
//            setValues(node.right, depth + 1, numbers);
//        }
//    }
}
