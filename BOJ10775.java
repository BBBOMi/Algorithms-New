package me.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * Created by Bomi on 2021/06/29.
 * 문제 출처 : https://www.acmicpc.net/problem/10775
 *
 * Time Complexity : O(N)
 * Used Algorithm : Union-Find
 * Used Data structure : Array
 */

public class BOJ10775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int gateCount = Integer.parseInt(br.readLine());
        int planeCount = Integer.parseInt(br.readLine());

        int answer = 0;
        int[] gates = IntStream.rangeClosed(0, gateCount).toArray();
        for (int i = 1; i <= planeCount; i++) {
            int plane = Integer.parseInt(br.readLine());

            int dockingGate = find(plane, gates);
            if (dockingGate == 0) break;

            union(dockingGate, dockingGate - 1, gates);
            answer++;
        }

        System.out.println(answer);
    }

    private static void union(int a, int b, int[] roots) {
        if (a > b) roots[a] = b;
        else roots[b] = a;
    }

    private static int find(int v, int[] roots) {
        if (roots[v] == v) return v;
        return roots[v] = find(roots[v], roots);
    }
}
