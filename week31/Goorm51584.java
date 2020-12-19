package me.algo.week31;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;

/**
 * Created by Bomi on 2020/12/19.
 * 문제 출처 : https://level.goorm.io/exam/51584/%EA%B5%AC%EB%A6%84-%EA%B2%8C%EC%9E%841-%EB%AF%B8%EC%99%84%EC%84%B1/quiz/1
 * <p>
 * Time Complexity : O(N^2)
 * Used Algorithm : Implementation
 * Used Data structure : Array, Map(HashMap), List(ArrayList)
 */

public class Goorm51584 {
    private static BufferedReader br;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] arr = new int[height][width];
        initArr(height, width, arr);

        Map<Integer, List<Integer>> operations = new HashMap<>();
        saveOperations(operations, Integer.parseInt(br.readLine()));

        printResult(height, width, arr, operations);
    }

    private static void initArr(int height, int width, int[][] arr) throws Exception {
        for (int i = 0; i < height; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    private static void saveOperations(Map<Integer, List<Integer>> operations, int count) throws Exception {
        while (count-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken()) - 1;

            operations.computeIfAbsent(line, (v) -> new ArrayList<>());
            operations.get(line).add(operation);
        }
    }

    private static void printResult(int height, int width, int[][] arr, Map<Integer, List<Integer>> operations) {
        final int OPERATION_WIDTH = 0;
        final int OPERATION_HEIGHT = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            int widthOperationCount = countChanges(i, OPERATION_WIDTH, operations);
            for (int j = 0; j < width; j++) {
                int heightOperationCount = countChanges(j, OPERATION_HEIGHT, operations);
                sb.append(changedResult(widthOperationCount + heightOperationCount, i, j, arr))
                        .append(" ");
            }
            sb.deleteCharAt(sb.length() - 1).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int changedResult(int changedCount, int i, int j, int[][] arr) {
        final int TOTAL_OPERATION_COUNT = 2;
        Predicate<Integer> isEven = (n) -> n % 2 == 0;
        return isEven.test(changedCount) ? arr[i][j] : (arr[i][j] + 1) % TOTAL_OPERATION_COUNT;
    }

    private static int countChanges(int index, int operation, Map<Integer, List<Integer>> operations) {
        final int DONT_CHANGE = 0;

        if (!operations.containsKey(index)) return DONT_CHANGE;
        if (!operations.get(index).contains(operation)) return DONT_CHANGE;
        return (int) operations.get(index).stream().filter(op -> op == operation).count();
    }
}
