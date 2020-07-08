package me.algo.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bomi on 2020/07/08.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/43163
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Queue(LinkedList)
 */

public class Main_43163 {
    private static final int INCONVERTIBLE = 0;
    static class Node {
        String text;
        int count;

        Node(String text, int count) {
            this.text = text;
            this.count = count;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int length = words.length;
        boolean[] visited = new boolean[length];
        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(begin, 0));

        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.text.equals(target)) {
                return current.count;
            }

            for(int i=0; i<length; i++) {
                if(!visited[i] && isNext(current.text, words[i])) {
                    queue.offer(new Node(words[i], current.count+1));
                    visited[i] = true;
                }
            }
        }
        return INCONVERTIBLE;
    }

    private static boolean isNext(String currentText, String text) {
        for(int i=0, count=0; i<currentText.length(); i++) {
            if(currentText.charAt(i) != text.charAt(i)) {
                if(++count > 1) return false;
            }
        }
        return true;
    }
}
