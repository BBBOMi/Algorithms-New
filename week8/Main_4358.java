package me.algo.week8;

import java.io.*;
import java.util.*;

/**
 * Created by Bomi on 2020/07/19.
 * 문제 출처 : https://www.acmicpc.net/problem/4358
 *
 * Time Complexity : O((log N) ^ 2)
 * Used Algorithm : 자료구조
 * Used Data structure : Map(TreeMap)
 */

public class Main_4358 {
    private static final double DECIMAL_PLACE = 10000.0;
    private static int totalCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> trees = new TreeMap<>();

        for(String name = br.readLine(); name != null; name = br.readLine()) {
            trees.put(name, trees.getOrDefault(name, 0) + 1);
            totalCount++;
        }

        if(trees.isEmpty()) return;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(getTrees(trees));
        bw.close();
    }

    private static String getTrees(Map<String, Integer> trees) {
        StringBuilder sb = new StringBuilder(trees.size());
        for(String name : trees.keySet()) {
            sb.append(name).append(" ")
                    .append(String.format("%.4f", getRatio(trees, name)))
                    .append("\n");
        }
        return sb.toString();
    }

    private static double getRatio(Map<String, Integer> map, String key) {
        double value = map.get(key);
        return Math.round(value  * DECIMAL_PLACE  * 100 / totalCount) / DECIMAL_PLACE;
    }
}
