package me.algo.week15.programmers;

import java.util.*;

/**
 * Created by Bomi on 2020/08/27.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/64065
 *
 * Time Complexity : O(N)
 * Used Algorithm : String, 자료구조
 * Used Data structure : Array, Set(LinkedHashSet)
 */

public class Main_64065 {
    public int[] solution(String s) {
        s = s.replaceAll("[{]", "");
        String[] arr = s.split("}");
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i].trim();
            String temp = "";
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) != ',') {
                    temp += str.charAt(j);
                }
                if (str.charAt(j) == ',' || j == str.length() - 1) {
                    if (!temp.equals("")) {
                        set.add(temp);
                        temp = "";
                    }
                }
            }
        }
        return set.stream().mapToInt(Integer::parseInt).toArray();
    }
}
