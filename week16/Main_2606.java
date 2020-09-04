package me.algo.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Bomi on 2020/09/04.
 * 문제 출처 : https://www.acmicpc.net/problem/2606
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Array, List(ArrayList), Queue(LinkedList)
 */

public class Main_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] computers = new List[n + 1];

        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (computers[from] == null) computers[from] = new ArrayList();
            if (computers[to] == null) computers[to] = new ArrayList();

            computers[from].add(to);
            computers[to].add(from);
        }
        System.out.println(countVirusComputers(1, computers));
    }

    private static int countVirusComputers(int start, List<Integer>[] computers) {
        boolean[] visited = new boolean[computers.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if(computers[current] == null) continue;
            for (int i = 0; i < computers[current].size(); i++) {
                int computer = computers[current].get(i);
                if (!visited[computer]) {
                    queue.offer(computer);
                    visited[computer] = true;
                    count++;
                }
            }
        }
        return count;
    }
}
