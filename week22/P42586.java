package me.algo.week22;

import java.util.Stack;

/**
 * Created by Bomi on 2020/10/17.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42586
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Stack, Array
 */

public class P42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        int maxDay = 0;
        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            if (maxDay >= day) {
                stack.push(stack.pop() + 1);
                continue;
            }
            maxDay = day;
            stack.push(1);
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
