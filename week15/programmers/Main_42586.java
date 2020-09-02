package me.algo.week15.programmers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2020/09/02.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42586
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Queue(LinkedList), List(ArrayList), Array
 */

public class Main_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList(Arrays.stream(progresses)
                .map(progress -> (100 - progress))
                .boxed().collect(Collectors.toList()));

        for(int speed : speeds) {
            int day = queue.peek() / speed;
            if(queue.poll() % speed != 0) day++;
            queue.offer(day);
        }

        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int day = queue.peek();
            int works = 0;
            while (!queue.isEmpty() && queue.peek() <= day) {
                queue.poll();
                works++;
            }
            answer.add(works);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
