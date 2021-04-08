package me.algo.week48.sun;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Bomi on 2021/04/08.
 * 문제 출처 : https://leetcode.com/problems/keys-and-rooms/
 *
 * Time Complexity : O(N)
 * Used Algorithm : DFS
 * Used Data structure : Set(HashSet), List
 */

public class Leet841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        dfs(0, rooms, visited);
        return visited.size() == rooms.size();
    }

    private static void dfs(int currentRoom, List<List<Integer>> rooms, Set<Integer> visited) {
        visited.add(currentRoom);
        for (int room : rooms.get(currentRoom)) {
            if (visited.contains(room)) continue;
            visited.add(room);
            dfs(room, rooms, visited);
        }
    }
}
