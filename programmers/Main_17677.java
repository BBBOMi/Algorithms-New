package me.algo.programmers;

import java.util.*;

/**
 * Created by Bomi on 2020/09/10.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/17677
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : 자료구조
 * Used Data structure : List(ArrayList), Set(HashSet)
 */

public class Main_17677 {
    private static final int MULTIPLY = 65536;
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        fillList(str1, list1);
        fillList(str2, list2);

        return (int)(getJ(list1, list2) * MULTIPLY);
    }

    private static void fillList(String str, List<String> list) {
        str = str.toUpperCase();
        for(int i=0; i<str.length()-1; i++) {
            String sub = str.substring(i, i+2).replaceAll("[^A-Z]", "");
            if(sub.length() != 2) continue;
            list.add(sub);
        }
    }

    private static int countIntersect(List<String> list1, List<String> list2) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<list1.size(); i++) {
            String str1 = list1.get(i);
            for(int j=0; j<list2.size(); j++) {
                String str2 = list2.get(j);
                if(str1.equals(str2) && !set.contains(j)) {
                    set.add(j);
                    break;
                }
            }
        }
        return set.size();
    }

    private static int countUnion(List<String> list1, List<String> list2) {
        return list1.size() + list2.size();
    }

    private static double getJ(List<String> list1, List<String> list2) {
        double intersection = countIntersect(list1, list2);
        double union = countUnion(list1, list2) - intersection;

        if(intersection == 0 && union == 0) return 1;
        return intersection / union;
    }
}
