package me.algo.programmers;

/**
 * Created by Bomi on 2020/07/01.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42584
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : 반복문
 * Used Data structure : Array
 */

public class Main_42584 {
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        for(int i=0; i<length; i++) {
            for(int j=i+1; j<length; j++) {
                answer[i] = j - i;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }
}
