package me.algo.week47.sun;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bomi on 2021/04/02.
 * 문제 출처 : https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * <p>
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : List(ArrayList, LinkedList)
 */

public class Leet1721 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> values = new ArrayList<>();
        values.add(0);

        ListNode temp = head;
        while (temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        int lastIndex = values.size() - k, count = 0;
        temp = head;
        while (temp != null) {
            ++count;

            if (count == k) {
                temp.val = values.get(lastIndex);
            }
            if (count == lastIndex) {
                temp.val = values.get(k);
            }

            temp = temp.next;
        }
        return head;
    }
}
