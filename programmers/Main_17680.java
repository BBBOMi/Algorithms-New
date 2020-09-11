package me.algo.programmers;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Bomi on 2020/09/11.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/17680
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : List(LinkedList), Array
 */

public class Main_17680 {
    public int solution(int cacheSize, String[] cities) {
        final int HIT = 1;
        final int MISS = 5;

        int time = 0;
        List<String> cache = new LinkedList<>();
        for(String city : cities) {
            String cityToUpperCase = city.toUpperCase();
            if (!cache.isEmpty() && cache.contains(cityToUpperCase)) {
                time += HIT;
                cache.remove(cityToUpperCase);
                cache.add(cityToUpperCase);
                continue;
            }

            time += MISS;
            cache.add(cityToUpperCase);
            if (cache.size() > cacheSize) cache.remove(0);
        }
        return time;
    }
}
