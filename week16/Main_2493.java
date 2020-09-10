package me.algo.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/09/10.
 * 문제 출처 : https://www.acmicpc.net/problem/2493
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Stack
 */

public class Main_2493 {
    static class Tower {
        int index;
        int height;

        Tower(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(getReceivingTower(n, br.readLine()));
    }

    private static String getReceivingTower(int towerCount, String towerHeights) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(towerHeights);
        Stack<Tower> towers = new Stack<>();
        for(int i=1; i<=towerCount; i++) {
            int height = Integer.parseInt(st.nextToken());

            while(!towers.isEmpty()) {
                if(towers.peek().height > height) {
                    sb.append(towers.peek().index).append(" ");
                    break;
                }
                towers.pop();
            }

            if(towers.isEmpty()) sb.append(0).append(" ");
            towers.push(new Tower(i, height));
        }

        return sb.toString();
    }
}
