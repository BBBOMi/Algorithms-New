package me.algo.leetcode;

/**
 * Created by Bomi on 2020/08/26.
 * 문제 출처 : https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 *
 * Time Complexity : O(N)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class Main_1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        for(int i=0; i<arr.length; i++) {
            if(arr[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
