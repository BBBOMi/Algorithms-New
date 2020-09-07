package me.algo.week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Bomi on 2020/09/03.
 * 문제 출처 : https://www.acmicpc.net/problem/3048
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Simulation
 * Used Data structure : Array
 */

public class Main_3048 {
    static class Ant {
        char c;
        char direction;

        Ant(char c, char direction) {
            this.c = c;
            this.direction = direction;
        }
    }

    private static Ant[] ants;

    private static final char LEFT = 'L';
    private static final char RIGHT = 'R';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        String group1 = br.readLine();
        String group2 = br.readLine();

        ants = new Ant[n1 + n2];
        int index = n1;
        for(char c : group1.toCharArray()) {
            ants[--index] = new Ant(c, RIGHT);
        }

        index = n1;
        for(char c : group2.toCharArray()) {
            ants[index++] = new Ant(c, LEFT);
        }

        getAntsAfterMoved(Integer.parseInt(br.readLine()));

        StringBuilder sb = new StringBuilder(n1+n2);
        for(Ant ant : ants) {
            sb.append(ant.c);
        }
        System.out.println(sb.toString());
    }

    private static void getAntsAfterMoved(int time) {
        boolean[] changeCheck = new boolean[ants.length];
        while (time-- > 0) {
            boolean change = false;
            for(int i=1; i<ants.length; i++) {
                if(!isJumpable(i-1, i, changeCheck)) continue;
                swap(i-1, i);
                changeCheck[i-1] = changeCheck[i] = true;
                change = true;
            }
            if(!change) return;
            Arrays.fill(changeCheck, false);
        }
    }

    private static boolean isJumpable(int left, int right, boolean[] changeCheck) {
        if(changeCheck[left] || changeCheck[right]) return false;
        if(ants[left].direction == ants[right].direction) return false;
        return ants[left].direction == RIGHT && ants[right].direction == LEFT;
    }

    private static void swap(int index1, int index2) {
        Ant temp = ants[index1];
        ants[index1] = ants[index2];
        ants[index2] = temp;
    }
}
