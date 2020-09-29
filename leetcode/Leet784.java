package me.algo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2020/09/29.
 * 문제 출처 : https://leetcode.com/problems/letter-case-permutation/
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Recursion, Backtracking
 * Used Data structure : List(ArrayList)
 */

public class Leet784 {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        letterCasePermutation(S, 0, result);
        return result;
    }

    private void letterCasePermutation(String str, int index, List<String> store) {
        if (str.length() == index) {
            store.add(str);
            return;
        }

        char c = str.charAt(index);
        if (Character.isLetter(c)) {
            String leftSub = str.substring(0, index);
            String rightSub = str.substring(index + 1);
            letterCasePermutation(leftSub + Character.toLowerCase(c) + rightSub, index + 1, store);
            letterCasePermutation(leftSub + Character.toUpperCase(c) + rightSub, index + 1, store);
        } else
            letterCasePermutation(str, index+1, store);
    }
}
