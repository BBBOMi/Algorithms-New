package me.algo.week15.programmers;

import java.util.*;

/**
 * Created by Bomi on 2020/08/31.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42890
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Backtracking
 * Used Data structure : Array, List(ArrayList), Set(HashSet)
 */

public class Main_42890 {
    private static List<Set<Integer>> candidates;
    private static int columns;

    public int solution(String[][] relation) {
        if (relation.length == 1) return relation[0].length;

        candidates = new ArrayList<>();
        columns = relation[0].length;

        for (int i = 1; i <= columns; i++) {
            findCandidates(0, i, new HashSet<>(), relation);
        }
        return candidates.size();
    }

    private static void findCandidates(int element, int size, Set<Integer> keys, String[][] relation) {
        if (keys.size() == size) {
            if(candidates.stream().anyMatch(keys::containsAll)) return;
            if (isDuplicated(keys, relation)) return;

            candidates.add(new HashSet<>(keys));
            return;
        }

        for (int i = element; i < columns; i++) {
            keys.add(i);
            findCandidates(i + 1, size, keys, relation);
            keys.remove(i);
        }
    }

    private static boolean isDuplicated(Set<Integer> keys, String[][] relation) {
        int rows = relation.length;
        Set<String> set = new HashSet<>(rows);
        for (int i = 0; i < rows; i++) {
            String data = "";
            for (int key : keys) {
                data += relation[i][key];
            }
            set.add(data);
        }
        return set.size() < rows;
    }
}
