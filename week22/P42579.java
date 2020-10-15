package me.algo.week22;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2020/10/15.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42579
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Hash
 * Used Data structure : Map(HashMap), List(ArrayList), Array
 */

public class P42579 {
    static class Song {
        int index;
        int playCount;

        Song(int index, int playCount) {
            this.index = index;
            this.playCount = playCount;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playCountMap = new HashMap<>();
        Map<String, List<Song>> genrePlayMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            playCountMap.put(genres[i], playCountMap.getOrDefault(genres[i], 0) + plays[i]);
            List<Song> values = genrePlayMap.getOrDefault(genres[i], new ArrayList<>());
            values.add(new Song(i, plays[i]));
            genrePlayMap.put(genres[i], values);
        }

        List<Integer> answer = new ArrayList<>();

        List<String> keys = playCountMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(Map.Entry::getKey).collect(Collectors.toList());

        keys.forEach(genre -> {
            List<Song> values = genrePlayMap.get(genre);
            if (values.size() < 2) {
                answer.add(values.get(0).index);
            } else {
                values.sort((s1, s2) -> s2.playCount ==  s1.playCount ? s1.index - s2.index : s2.playCount - s1.playCount);
                for (int i = 0; i < 2; i++) {
                    answer.add(values.get(i).index);
                }
            }
        });
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
