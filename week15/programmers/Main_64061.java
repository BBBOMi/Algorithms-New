package me.algo.week15.programmers;

import java.util.Stack;

/**
 * Created by Bomi on 2020/08/28.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/64061
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : 자료구조
 * Used Data structure : Array, Stack
 */

public class Main_64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
            int doll = popDoll(moves[i] - 1, board);
            if (doll == 0) continue;
            if (!bucket.isEmpty() && bucket.peek() == doll) {
                bucket.pop();
                answer += 2;
                continue;
            }
            bucket.push(doll);
        }
        return answer;
    }

    private static int popDoll(int index, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][index] != 0) {
                int doll = board[i][index];
                board[i][index] = 0;
                return doll;
            }
        }
        return 0;
    }
}
