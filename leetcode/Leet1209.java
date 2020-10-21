package me.algo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Bomi on 2020/10/21.
 * 문제 출처 : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Deque(ArrayDeque)
 */

public class Leet1209 {
    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Deque<Pair> queue = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (queue.isEmpty() || queue.peekLast().ch != c) {
                queue.offerLast(new Pair(c, 1));
                continue;
            }
            queue.peekLast().count++;
            while (!queue.isEmpty() && queue.peekLast().count == k) {
                queue.pollLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Pair pair = queue.pollFirst();
            for (int i = 0; i < pair.count; i++) {
                sb.append(pair.ch);
            }
        }
        return sb.toString();
    }
}
