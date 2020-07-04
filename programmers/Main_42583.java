package me.algo.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2020/07/01.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42583
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Queue(LinkedList)
 */

public class Main_42583 {
    static class Truck {
        int weight;
        int entry;

        Truck(int weight, int entry) {
            this.weight = weight;
            this.entry = entry;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> bridge = new LinkedList<>();
        Queue<Truck> waitQueue = new LinkedList(Arrays.stream(truck_weights)
                                                        .mapToObj(w -> new Truck(w, 0))
                                                        .collect(Collectors.toList()));
        int second = 0, presentWeight = 0;
        while(!waitQueue.isEmpty() || !bridge.isEmpty()) {
            second++;
            if(!bridge.isEmpty()) {
                Truck truck = bridge.peek();
                if((second - truck.entry) >= bridge_length) {
                    bridge.poll();
                    presentWeight -= truck.weight;
                }
            }
            if(!waitQueue.isEmpty()) {
                if((presentWeight + waitQueue.peek().weight) <= weight) {
                    Truck truck = waitQueue.poll();
                    presentWeight += truck.weight;
                    bridge.offer(new Truck(truck.weight, second));
                }
            }
        }
        return second;
    }
}
