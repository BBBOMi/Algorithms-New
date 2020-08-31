package me.algo.week15.programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2020/08/28.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42888
 *
 * Time Complexity : O(N)
 * Used Algorithm : 해싱
 * Used Data structure : Map(HashMap), List(ArrayList), Array
 */

public class Main_42888 {
    public String[] solution(String[] record) {
        Map<String, String> users = new HashMap<>();
        List<String> logs = new ArrayList<>();
        for (String r : record) {
            StringTokenizer st = new StringTokenizer(r);
            String order = st.nextToken();
            String id = st.nextToken();

            if ("Leave".equals(order)) {
                logs.add(id + "님이 나갔습니다.");
                continue;
            }

            String nick = st.nextToken();
            users.put(id, nick);

            if ("Enter".equals(order)) {
                logs.add(id + "님이 들어왔습니다.");
            }
        }

        return logs.stream()
                .map(log -> {
                    int index = log.indexOf("님");
                    String uid = log.substring(0, index);
                    return users.get(uid) + log.substring(index);
                })
                .collect(Collectors.toList()).toArray(new String[]{});
    }
}
