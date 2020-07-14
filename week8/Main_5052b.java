package me.algo.week8;

import java.io.*;

/**
 * Created by Bomi on 2020/07/14.
 * 문제 출처 : https://www.acmicpc.net/problem/5052
 *
 * Time Complexity : O(N)
 * Used Algorithm : Trie
 * Used Data structure : Array, TrieNode
 */

public class Main_5052b {
    private static final String CONSISTENCY = "YES";
    private static final String INCONSISTENCY = "NO";

    static class TrieNode {
        TrieNode[] child;
        boolean isTerminal;

        TrieNode() {
            // 숫자 개수만큼의 크기로 초기화(0~9)
            this.child = new TrieNode[10];
        }
    }

    private static TrieNode root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumbers = new String[n];
            for (int j = 0; j < n; j++) {
                phoneNumbers[j] = br.readLine();
            }
            root = new TrieNode();
            setTrieNode(phoneNumbers);
            bw.write(isPrefix(phoneNumbers) ? INCONSISTENCY + "\n" : CONSISTENCY + "\n");
        }
        bw.close();
    }

    private static void setTrieNode(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            TrieNode node = root;
            String number = arr[i];
            for (int j = 0; j < number.length(); j++) {
                int idx = number.charAt(j) - '0';
                if (node.child[idx] == null) {
                    node.child[idx] = new TrieNode();
                }
                if (j == number.length() - 1) {
                    node.child[idx].isTerminal = true;
                    break;
                }
                node = node.child[idx];
            }
        }
    }

    private static boolean isPrefix(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            TrieNode node = root;
            String number = arr[i];
            for (int j = 0; j < number.length(); j++) {
                int idx = number.charAt(j) - '0';
                if(node.isTerminal && node.child[idx] != null) {
                    return true;
                }
                node = node.child[idx];
            }
        }
        return false;
    }
}
