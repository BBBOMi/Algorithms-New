package me.algo.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2020/11/10.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12946
 *
 * Time Complexity : O(2^N)
 * Used Algorithm : recursion
 * Used Data structure : Array, List(ArrayList)
 */

public class P12946 {
    public int[][] solution(int n) {
        List<int[]> moves = new ArrayList<>();
        hanoi(n, 1, 2, 3, moves);
        return moves.toArray(new int[0][]);
    }

    private void hanoi(int n, int from, int by, int to, List<int[]> moves) {
        if (n == 1) {
            moves.add(new int[]{from, to});
            return;
        }

        hanoi(n - 1, from, to, by, moves);
        moves.add(new int[]{from, to});
        hanoi(n - 1, by, from, to, moves);
    }
}
