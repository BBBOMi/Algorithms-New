package me.algo.week28;

import java.util.*;

/**
 * Created by Bomi on 2020/11/27.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/64064
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Backtracking
 * Used Data structure : Set(HashSet), List(ArrayList), Array
 */

public class P64064 {
    private static Set<List<Integer>> answer;

    public int solution(String[] user_id, String[] banned_id) {
        answer = new HashSet<>();
        banned_id = changeBannedIds(banned_id);
        countBannedIdList(user_id, banned_id, 0, new ArrayList(), new boolean[user_id.length]);
        return answer.size();
    }

    private void countBannedIdList(String[] userIds, String[] bannedIds, int bannedIdIndex, List<Integer> selectedIds, boolean[] userChecked) {
        if (bannedIdIndex == bannedIds.length) {
            List<Integer> result = new ArrayList<>(selectedIds);
            Collections.sort(result);
            answer.add(result);
            return;
        }

        for (int i = 0; i < userIds.length; i++) {
            if (!userChecked[i] && userIds[i].matches(bannedIds[bannedIdIndex])) {
                userChecked[i] = true;
                selectedIds.add(i);
                countBannedIdList(userIds, bannedIds, bannedIdIndex + 1, selectedIds, userChecked);
                userChecked[i] = false;
                selectedIds.remove(selectedIds.size() - 1);
            }
        }
    }

    private String[] changeBannedIds(String[] bannedIds) {
        return Arrays.stream(bannedIds)
                .map(id -> id.replace('*', '.')) // 정규 표현식으로 변경
                .toArray(String[]::new);
    }
}
