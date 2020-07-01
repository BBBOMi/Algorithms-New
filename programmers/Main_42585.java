package me.algo.programmers;

import java.util.Stack;

/**
 * Created by Bomi on 2020/07/01.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42585
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조(Stack)
 * Used Data structure : Stack
 */

public class Main_42585 {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0, len=arrangement.length(); i<len; i++) {
            if (arrangement.charAt(i) == '(') {
                stack.push(i);
                continue;
            }
            if(stack.peek() == i-1) {
                stack.pop();
                answer += stack.size();
                continue;
            }
            stack.pop();
            answer++;
        }
        return answer;
    }
}
