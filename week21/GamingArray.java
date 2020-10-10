package me.algo.week21;

import java.util.*;

/**
 * Created by Bomi on 2020/10/10.
 * 문제 출처 : https://www.hackerrank.com/challenges/an-interesting-game-1/problem
 *
 * Time Complexity : O(N)
 * Used Algorithm : Constructive
 * Used Data structure :
 */

public class GamingArray {
    public static String gamingArray(List<Integer> arr) {
        Stack<Integer> stack = new Stack<>();
        for(int n : arr) {
            if(!stack.isEmpty() && stack.peek() > n) continue;
            stack.push(n);
        }
        return stack.size() % 2 == 0 ? "ANDY" : "BOB";
    }
}
