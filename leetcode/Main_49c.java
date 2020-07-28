package me.algo.leetcode;

import java.util.*;

/**
 * Created by Bomi on 2020/07/28.
 * 문제 출처 : https://leetcode.com/problems/group-anagrams/
 *
 * Time Complexity : O(N)
 * Used Algorithm : Hashing, 소수
 * Used Data structure : Array, Map(HashMap), List(ArrayList)
 */

public class Main_49c {
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] primeNumbers = getPrimeNumbers(26);
        Map<Long, List<String>> map = new HashMap<>();
        for(String s : strs) {
            long sub = 1;
            for(char c : s.toCharArray()) {
                sub *= (primeNumbers[c - 'a']);
            }
            List<String> value = map.getOrDefault(sub, new ArrayList());
            value.add(s);
            map.put(sub, value);
        }
        return new ArrayList<>(map.values());
    }

    private static int[] getPrimeNumbers(int size) {
        boolean[] isPrimes = new boolean[size*4];
        Arrays.fill(isPrimes, true);
        isPrimes[0] = isPrimes[1] = false;
        for(int i = 2; i*i<isPrimes.length; i++) {
            for(int j=i+i; j<isPrimes.length; j += i) {
                isPrimes[j] = false;
            }
        }

        int[] numbers = new int[size];
        for(int i=0, index=0; i<isPrimes.length && index < numbers.length; i++) {
            if(isPrimes[i]) {
                numbers[index++] = i;
            }
        }
        return numbers;
    }
}
