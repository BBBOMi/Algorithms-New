package me.algo.leetcode;

import java.util.Stack;

/**
 * Created by Bomi on 2020/10/13.
 * 문제 출처 : https://leetcode.com/problems/valid-parenthesis-string/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Stack
 */

public class Leet678 {
    public boolean checkValidString(String s) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> asterisk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left.push(i);
            else if (c == '*') asterisk.push(i);
            else {
                if (left.isEmpty() && asterisk.isEmpty()) return false;
                if (!left.isEmpty()) left.pop();
                else asterisk.pop();
            }
        }
        while (!left.isEmpty() && !asterisk.isEmpty()) {
            if (left.pop() > asterisk.pop()) return false;
        }
        return left.isEmpty();
    }
}
