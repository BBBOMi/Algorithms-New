package me.algo.week1;

/**
 * Created by Kyeongmoon on 2020/05/19.
 * 문제 출처 : 경문이 머릿속
 * <p>
 * Time Complexity : O(N)
 * Used Algorithm : BFS
 * Used Data structure : Array, Queue
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args){
        new Main().solve();
    }

    class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    int[][] map;
    boolean[][] visit;

    Node end;

    int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    void solve() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Queue<Node> queue = new ArrayDeque<>();
            map = new int[4][4];
            visit = new boolean[4][4];

            queue.offer(new Node(0, 0));
            visit[0][0] = true;

            for (int i = 0; i < 4; i++) {
                String[] splits = br.readLine().split("");
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(splits[j]);
                }
            }

            // 목적
            end = new Node(3, 3);

            while (!queue.isEmpty()) {
                Node item = queue.poll();

                if (item.y == end.y && item.x == end.x) {
                    System.out.println("arrive!");
                    break;
                }

                int newY;
                int newX;

                for (int i = 0; i < 4; i++) {
                    newY = item.y + direction[i][0];
                    newX = item.x + direction[i][1];

                    if (newY >= 4 || newY < 0 || newX >= 4 || newX < 0) {
                        continue;
                    }

                    if (map[newY][newX] == 0) {
                        continue;
                    }

                    if (visit[newY][newX]) {
                        continue;
                    }

                    System.out.println(newY + ", " + newX);

                    visit[newY][newX] = true;
                    queue.offer(new Node(newY, newX));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
