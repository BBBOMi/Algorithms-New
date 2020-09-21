package me.algo.programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2020/07/07.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42579
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Hashing
 * Used Data structure : Map(HashMap), List(ArrayList), Array
 */

public class Main_42579 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> songFrequency = new HashMap<>();
        Map<String, List<Integer>> songPlays = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            songFrequency.put(genres[i], songFrequency.getOrDefault(genres[i], 0) + plays[i]);
            List<Integer> values = songPlays.getOrDefault(genres[i], new ArrayList<>());
            values.add(i);
            songPlays.put(genres[i], values);
        }

        List<String> keys = songFrequency.entrySet().stream()
                .sorted((e1, e2) -> (e2.getValue() - e1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();
        for (String k : keys) {
            List<Integer> indexes = new ArrayList<>();
            for (int i : songPlays.get(k)) {
                indexes.add(i);
                if (indexes.size() <= 2) continue;

                int minIndex = indexes.get(0);
                for (int j = 1; j < indexes.size(); j++) {
                    if(plays[minIndex] > plays[indexes.get(j)]) minIndex = indexes.get(j);
                }
                indexes.remove((Integer)minIndex);
            }

            if (indexes.size() == 2 && plays[indexes.get(0)] < plays[indexes.get(1)]) swap(indexes);
            answer.addAll(indexes);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void swap(List<Integer> list) {
        list.add(list.remove(0));
    }
}
