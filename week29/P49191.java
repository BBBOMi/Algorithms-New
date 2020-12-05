package me.algo.week29;

import java.util.Arrays;

/**
 * Created by Bomi on 2020/12/05.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/49191
 *
 * Time Complexity : O(N^3)
 * Used Algorithm : Floyd-warshall
 * Used Data structure : Array
 */

public class P49191 {
    public int solution(int n, int[][] results) {
        boolean[][] winning = new boolean[n + 1][n + 1];
        Arrays.stream(results)
                .forEach((int[] result) -> winning[result[0]][result[1]] = true);

        setTotalPlayResult(n, winning);

        return countPeopleWithTheCorrectRank(n, winning);
    }

    private void setTotalPlayResult(int n, boolean[][] winning) {
        for (int loser = 1; loser <= n; loser++) {
            for (int winner = 1; winner <= n; winner++) {
                for (int topLoser = 1; topLoser <= n; topLoser++) {
                    if (winning[winner][loser] && winning[loser][topLoser]) {
                        winning[winner][topLoser] = true;
                    }
                }
            }
        }
    }

    private int countPeopleWithTheCorrectRank(int playerCount, boolean[][] winning) {
        int answer = 0;
        for (int i = 1; i <= playerCount; i++) {
            int count = 0;
            for (int j = 1; j <= playerCount; j++) {
                if (winning[i][j] || winning[j][i]) {
                    count++;
                }
            }
            if (count == playerCount - 1) answer++;
        }
        return answer;
    }
}
