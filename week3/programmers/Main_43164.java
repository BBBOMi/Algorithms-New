package me.algo.week3.programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Bomi on 2020/06/06.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/43164
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : DFS, Backtracking
 * Used Data structure : Array, List(ArrayList)
 */

public class Main_43164 {
    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length];
        Arrays.sort(tickets, Comparator.comparing((String[] array) -> array[1]));

        List<String> answer =  new ArrayList<>();
        dfs("ICN", tickets, visited, answer);

        return answer.toArray(new String[]{});
    }

    private static boolean dfs(String from, String[][] tickets, boolean[] visited, List<String> list) {
        list.add(from);

        if(list.size() == visited.length+1) {
            return true;
        }

        for(int i=0, len=tickets.length; i<len; i++) {
            if(from.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                boolean success = dfs(tickets[i][1], tickets, visited, list);
                if(success) {
                    return true;
                }
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
        return false;
    }
}
