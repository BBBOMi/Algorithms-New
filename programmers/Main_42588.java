package me.algo.programmers;

import java.util.Stack;

/**
 * Created by Bomi on 2020/07/04.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42588
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Stack
 */

public class Main_42588 {
    public int[] solution(int[] heights) {
        int towersCount = heights.length;
        Stack<Integer> towers = new Stack<>();
        for(int i=0; i<towersCount; i++) {
            towers.push(heights[i]);
        }

        int[] answer = new int[towersCount];
        Stack<Integer> movedTower = new Stack<>();
        for(int i=towersCount-1; i>=0; i--) {
            int length = towers.pop();
            while(!towers.isEmpty()) {
                int peek = towers.peek();
                if(peek > length) {
                    answer[i] = i - movedTower.size();
                    break;
                }
                movedTower.push(towers.pop());
            }
            while(!movedTower.isEmpty()) {
                towers.push(movedTower.pop());
            }
        }
        return answer;
    }
}
