package me.algo.week47.sun;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Bomi on 2021/04/01.
 * 문제 출처 : https://leetcode.com/problems/integer-to-roman/
 *
 * Time Complexity : O(log N)
 * Used Algorithm : String
 * Used Data structure : Map(TreeMap)
 */

public class Leet12 {
    public String intToRoman(int num) {
        Map<Integer, String> dictionary = new TreeMap<>(Comparator.reverseOrder());
        fillDictionary(dictionary);

        StringBuilder answer = new StringBuilder();
        for (int key : dictionary.keySet()) {
            if (key > num) continue;

            while (num >= key) {
                answer.append(dictionary.get(key));
                num -= key;
            }
        }
        return answer.toString();
    }

    private static void fillDictionary(Map<Integer, String> dictionary) {
        dictionary.put(1, "I");
        dictionary.put(4, "IV");
        dictionary.put(5, "V");
        dictionary.put(9, "IX");
        dictionary.put(10, "X");
        dictionary.put(40, "XL");
        dictionary.put(50, "L");
        dictionary.put(90, "XC");
        dictionary.put(100, "C");
        dictionary.put(400, "CD");
        dictionary.put(500, "D");
        dictionary.put(900, "CM");
        dictionary.put(1000, "M");
    }
}
