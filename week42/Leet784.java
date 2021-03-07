package me.algo.week42;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2021/03/07.
 * 문제 출처 : https://leetcode.com/problems/letter-case-permutation/
 *
 * Time Complexity : O(2 ^ (문자 개수))
 * Used Algorithm : Backtracking
 * Used Data structure : List(ArrayList)
 */

public class Leet784 {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        backtracking(S, "", 0, result);
        return result;
    }

    private void backtracking(String origin, String transformation, int index, List<String> result) {
        if (index >= origin.length()) {
            result.add(transformation);
            return;
        }

        char currentChar = origin.charAt(index);
        if (Character.isLetter(currentChar)) {
            backtracking(origin, transformation + Character.toLowerCase(currentChar), index + 1, result);
            backtracking(origin, transformation + Character.toUpperCase(currentChar), index + 1, result);
        } else {
            backtracking(origin, transformation + currentChar, index + 1, result);
        }
    }
}
