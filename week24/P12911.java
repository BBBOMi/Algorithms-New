package me.algo.week24;

/**
 * Created by Bomi on 2020/10/30.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/12911
 *
 * Time Complexity : O(N)
 * Used Algorithm : Math
 * Used Data structure : Array
 */

public class P12911 {
    public int solution(int n) {
        int oneCount = countOne(n);
        int answer = n + 1;
        while (oneCount != countOne(answer)) {
            answer++;
        }
        return answer;
    }

    private int countOne(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (char b : binaryString.toCharArray()) {
            if (b == '1') count++;
        }
        return count;
    }
}
