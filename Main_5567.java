package me.algo;

import java.io.*;
import java.util.*;

/**
 * Created by Bomi on 2020/06/21.
 * 문제 출처 : https://www.acmicpc.net/problem/5567
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : 구현
 * Used Data structure : Array, Set(HashSet)
 */

public class Main_5567 {
    private static Set<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] friends = new List[n+1];
        for(int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(friends[a] == null) {
                friends[a] = new LinkedList<>();
            }
            if(friends[b] == null) {
                friends[b] = new LinkedList<>();
            }
            friends[a].add(b);
            friends[b].add(a);
        }
        result = new HashSet<>();
        searchFriends(friends);
        System.out.println(result.size() - 1);
    }

    private static void searchFriends(List<Integer>[] friends) {
        for(int friend : friends[1]) {
            result.add(friend);
            for(int f : friends[friend]) {
                result.add(f);
            }
        }
    }
}