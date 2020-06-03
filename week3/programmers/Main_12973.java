package me.algo.week3.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2020/06/03.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12973
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Stack(ArrayList)
 */

public class Main_12973 {
    private static final int SUCCESS = 1;
    private static final int FAIL = 0;

    private static List<Character> stack;

    public int solution(String s) {
        stack = new ArrayList<>();
        char[] chars = s.toCharArray();
        for(char ch : chars) {
            if(!stack.isEmpty() && peek() == ch) {
                poll();
                continue;
            }
            stack.add(ch);
        }
        return stack.isEmpty() ? SUCCESS : FAIL;
    }

    private char peek() {
      return stack.get(stack.size()-1);
    }

    private char poll() {
        return stack.remove(stack.size()-1);
    }
}
