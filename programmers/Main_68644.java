package me.algo.programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bomi on 2020/09/14.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/62048
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Array
 * Used Data structure : Array
 */

public class Main_68644 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length; i++) {
            for(int j=i+1; j<numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}
