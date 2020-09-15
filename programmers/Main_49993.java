package me.algo.programmers;

/**
 * Created by Bomi on 2020/09/15.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/49993
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : String
 * Used Data structure : Array
 */

public class Main_49993 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (String skills : skill_trees) {
            String s = "";
            for (char c : skills.toCharArray()) {
                if (skill.indexOf(c) >= 0) s += c;
            }
            if (skill.startsWith(s)) answer++;
        }
        return answer;
    }
}
