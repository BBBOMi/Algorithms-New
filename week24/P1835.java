package me.algo.week24;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2020/11/08.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/1835
 *
 * Time Complexity : O(N)
 * Used Algorithm : Backtracking
 * Used Data structure : Array, List(ArrayList)
 */

public class P1835 {
    private static final char[] FRIENDS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private static final int FRIENDS_COUNT = FRIENDS.length;

    public int solution(int n, String[] data) {
        return backtracking(0, 0, new ArrayList<>(), data);
    }

    private int backtracking(int count, int size, List<Character> order, String[] data) {
        if (size == FRIENDS_COUNT) {
            if (isPossible(order, data)) return ++count;
            return count;
        }

        for (int i = 0; i < FRIENDS_COUNT; i++) {
            if (order.contains(FRIENDS[i])) continue;
            order.add(FRIENDS[i]);
            count = backtracking(size + 1, count, order, data);
            order.remove(size);
        }
        return count;
    }

    private boolean isPossible(List<Character> order, String[] data) {
        for (String condition : data) {
            char friend1 = condition.charAt(0);
            char friend2 = condition.charAt(2);

            int wantedGap = Character.digit(condition.charAt(4), 10);
            int realGap = Math.abs(order.indexOf(friend1) - order.indexOf(friend2)) - 1;

            char operation = condition.charAt(3);
            if (operation == '=') {
                if (wantedGap != realGap) return false;
                continue;
            }
            if (operation == '<') {
                if (wantedGap <= realGap) return false;
                continue;
            }
            if (wantedGap >= realGap) return false;
        }
        return true;
    }
}
