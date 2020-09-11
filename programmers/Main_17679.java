package me.algo.programmers;


/**
 * Created by Bomi on 2020/09/11.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/17679
 *
 * Time Complexity : O(N^2)
 * Used Algorithm : Graph
 * Used Data structure : Array
 */

public class Main_17679 {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];

        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        int answer = 0;
        while (true) {
            int count = checkBlocks(m, n, map);
            if (count == 0) break;
            answer += count;

            dropBlocks(m, n, map);
        }

        return answer;
    }

    private int checkBlocks(int m, int n, char[][] map) {
        int count = 0;
        boolean[][] checked = new boolean[m][n];

        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == '.') continue;
                checkFourBlocks(i, j, checked, map);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!checked[i][j]) continue;
                count++;
                map[i][j] = '.';
            }
        }
        return count;
    }

    private void checkFourBlocks(int x, int y, boolean[][] checked, char[][] map) {
        for (int i = x; i < x + 2; i++) {
            for (int j = y; j < y + 2; j++) {
                if (map[x][y] != map[i][j]) return;
            }
        }

        for (int i = x; i < x + 2; i++) {
            for (int j = y; j < y + 2; j++) {
                checked[i][j] = true;
            }
        }
    }

    private static void dropBlocks(int m, int n, char[][] map) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (map[j][i] != '.') continue;

                for (int r = j - 1; r >= 0; r--) {
                    if (map[r][i] != '.') {
                        map[j][i] = map[r][i];
                        map[r][i] = '.';
                        break;
                    }
                }
            }
        }
    }
}
