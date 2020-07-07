package me.algo.programmers;

import java.util.*;

/**
 * Created by Bomi on 2020/07/07.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42578
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Map(HashMap)
 */

public class Main_42578 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++) {
            String type = clothes[i][1];
            map.put(type, map.getOrDefault(type, 0)+1);
        }

        int answer = 1;
        for(int value : map.values()) {
            answer *= (value) + 1;
        }
        return --answer;
    }

}
