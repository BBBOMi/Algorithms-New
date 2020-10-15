package me.algo.week22;

/**
 * Created by Bomi on 2020/10/15.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/43163
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Array
 */

public class P43163 {
    private static int result;

    public int solution(String begin, String target, String[] words) {
        result = Integer.MAX_VALUE;
        solution(begin, target, words, new boolean[words.length], 0);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    private void solution(String begin, String target, String[] words, boolean[] visited, int count) {
        if (begin.equals(target)) {
            result = Math.min(count, result);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isNext(begin, words[i])) {
                visited[i] = true;
                solution(words[i], target, words, visited, count + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isNext(String current, String next) {
        int count = 0;
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) == next.charAt(i)) count++;
        }
        return count == current.length() - 1;
    }
}
