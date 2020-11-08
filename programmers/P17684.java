package me.algo.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Bomi on 2020/11/09.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/17684
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Hash, String
 * Used Data structure : Map(HashMap), List(ArrayList)
 */

public class P17684 {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        int index = 0;
        while (index < 26) {
            dictionary.put(String.valueOf((char) ('A' + index)), ++index);
        }

        List<Integer> list = new ArrayList<>();
        int fromIndex = 0, toIndex = msg.length() + 1;
        while (fromIndex <= toIndex && fromIndex < msg.length()) {
            while (--toIndex > fromIndex && !dictionary.containsKey(msg.substring(fromIndex, toIndex))) ;

            list.add(dictionary.get(msg.substring(fromIndex, toIndex)));

            if (toIndex < msg.length()) {
                dictionary.put(msg.substring(fromIndex, toIndex + 1), ++index);
            }

            fromIndex = toIndex;
            toIndex = msg.length() + 1;
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
