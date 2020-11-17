package me.algo.week26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Bomi on 2020/11/17.
 * 문제 출처 : https://www.acmicpc.net/problem/9663
 *
 * Time Complexity : O(N^3)
 * Used Algorithm : Brute-force, Backtracking
 * Used Data structure : Array
 */

public class BOJ9663 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(countNQueen(0, 0, n, new boolean[n][n]));
    }

    private static int countNQueen(int depth, int answer, int n, boolean[][] chessBoard) {
        if (depth == n) return ++answer;

        for (int i = 0; i < n; i++) {
            if (chessBoard[i][depth] || !isValid(i, depth, chessBoard)) continue;
            chessBoard[i][depth] = true;
            answer = countNQueen(depth + 1, answer, n, chessBoard);
            chessBoard[i][depth] = false;
        }
        return answer;
    }

    private static boolean isValid(int x, int y, boolean[][] chessBoard) {
        for (int i = 0; i < y; i++) { // 현재 위치를 기준으로 왼쪽 가로 확인
            if (chessBoard[x][i]) return false;
        }
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) { // 현재 위치의 왼쪽 위 대각선(\) 확인
            if (chessBoard[i][j]) return false;
        }
        for (int i = x + 1, j = y - 1; i < chessBoard.length && j >= 0; i++, j--) { // 현재 위치의 왼쪽 아래 대각선(/) 확인
            if (chessBoard[i][j]) return false;
        }
        return true;
    }
}
