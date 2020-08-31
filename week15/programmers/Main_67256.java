package me.algo.week15.programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Bomi on 2020/08/31.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/67256
 *
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Array, Queue(LinkedList)
 */

public class Main_67256 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int[][] keypad = {
            {1, 2, 3}
            , {4, 5, 6}
            , {7, 8, 9}
            , {10, 0, 12}
    };

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder(numbers.length);

        int currentLeft = 10, currentRight = 12;
        for (int i = 0; i < numbers.length; i++) {
            switch (numbers[i]) {
                case 1: case 4: case 7:
                    answer.append("L");
                    currentLeft = numbers[i];
                    break;

                case 3: case 6: case 9:
                    answer.append("R");
                    currentRight = numbers[i];
                    break;

                default:
                    int movedLeft = countSteps(currentLeft, numbers[i]);
                    int movedRight = countSteps(currentRight, numbers[i]);

                    if (movedLeft < movedRight) {
                        answer.append("L");
                        currentLeft = numbers[i];
                    } else if (movedLeft > movedRight) {
                        answer.append("R");
                        currentRight = numbers[i];
                    } else {
                        if (hand.equals("left")) {
                            currentLeft = numbers[i];
                            answer.append("L");
                        }
                        else {
                            currentRight = numbers[i];
                            answer.append("R");
                        }
                    }
            }
        }
        return answer.toString();
    }

    private static int countSteps(int from, int to) {
        int[][] count = new int[keypad.length][keypad[0].length];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(getCurrentPoint(from));
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (keypad[current[0]][current[1]] == to) return count[current[0]][current[1]];

            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];

                if (nextX < 0 || nextX >= keypad.length || nextY < 0 || nextY >= keypad[0].length)
                    continue;

                count[nextX][nextY] = count[current[0]][current[1]] + 1;
                queue.offer(new int[]{nextX, nextY});
            }
        }
        return -1;
    }

    private static int[] getCurrentPoint(int currentNumber) {
        for (int i = 0; i < keypad.length; i++) {
            for (int j = 0; j < keypad[0].length; j++) {
                if (keypad[i][j] == currentNumber) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}
