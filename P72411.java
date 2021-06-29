package me.algo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2021/06/29.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/72411
 *
 * Time Complexity : O(N * M * K)
 * Used Algorithm : 완전탐색
 * Used Data structure : Array, Map(HashMap), List(ArrayList)
 */

public class P72411 {
    private static final int MIN_COUNT = 2;

    private Map<String, Integer> menus;
    private int maxCount;

    public String[] solution(String[] orders, int[] course) {
        List<String> newMenus = new ArrayList<>();
        for (int count : course) {
            menus = new HashMap<>();
            maxCount = 0;

            Arrays.stream(orders)
                    .forEach(order -> find("", 0, order, count));

            if (maxCount < MIN_COUNT) continue;
            menus.keySet().stream()
                    .filter(it -> menus.get(it) == maxCount)
                    .forEach(newMenus::add);
        }

        return newMenus.stream().sorted().toArray(String[]::new);
    }

    private void find(String current, int index, String order, int length) {
        if (current.length() == length) {
            String sortedCurrent = Arrays.stream(current.split("")).sorted().collect(Collectors.joining());
            menus.put(sortedCurrent, menus.getOrDefault(sortedCurrent, 0) + 1);
            maxCount = Math.max(maxCount, menus.get(sortedCurrent));
            return;
        }

        for (int i = index; i < order.length(); i++) {
            find(current + order.charAt(i), i + 1, order, length);
        }
    }
}
