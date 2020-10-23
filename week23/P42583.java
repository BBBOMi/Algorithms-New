package me.algo.week23;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * Created by Bomi on 2020/10/23.
 * 문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/42583
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : Queue(LinkedList)
 */

public class P42583 {
    static class Truck {
        int weight;
        int second;

        Truck(int weight, int second) {
            this.weight = weight;
            this.second = second;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> waitingQueue = Arrays.stream(truck_weights).mapToObj(i -> new Truck(i, 0))
                .collect(Collectors.toCollection(LinkedList::new));
        Queue<Truck> bridge = new LinkedList<>();

        int second = 0, currentWeight = 0;
        while (!waitingQueue.isEmpty() || !bridge.isEmpty()) {
            second++;
            if(!bridge.isEmpty()) {
                Truck truck = bridge.peek();
                if(second - truck.second >= bridge_length) {
                    bridge.poll();
                    currentWeight -= truck.weight;
                }
            }
            if(!waitingQueue.isEmpty()) {
                if (currentWeight + waitingQueue.peek().weight <= weight) {
                    Truck truck = waitingQueue.poll();
                    currentWeight += truck.weight;
                    bridge.offer(new Truck(truck.weight, second));
                }
            }
        }
        return second;
    }
}
