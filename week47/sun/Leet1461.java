package me.algo.week47.sun;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Bomi on 2021/04/02.
 * 문제 출처 : https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Queue(LinkedList), Set(HashSet)
 */

public class Leet1461 {
    public boolean hasAllCodes(String s, int k) {
        Queue<Character> binaryStrings = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        for (char ch : s.toCharArray()) {
            binaryStrings.offer(ch);
            if (binaryStrings.size() == k) {
                seen.add(binaryStrings.toString());
                binaryStrings.poll();
            }
        }
        return seen.size() == (1 << k);
    }
}
