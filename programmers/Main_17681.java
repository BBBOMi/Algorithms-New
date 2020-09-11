package me.algo.programmers;

/**
 * Created by Bomi on 2020/09/11.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/17681
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class Main_17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
        }

        for(int i=0; i<n; i++) {
            answer[i] = String.format("%" + n + "s", answer[i])
                    .replaceAll("1", "#")
                    .replaceAll("0", " ");
        }

        return answer;
    }


}
