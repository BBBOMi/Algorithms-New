package me.algo.week23;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bomi on 2020/10/22.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42578
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hash
 * Used Data structure : Array, Map(HashMap)
 */

public class P42578 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(clothes).forEach(cloth -> map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1));
        return map.values().stream().mapToInt(value -> (value) + 1).reduce(1, (a, b) -> a * b) - 1;
    }
}
