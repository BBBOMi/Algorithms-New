package me.algo.week46.sun;

/**
 * Created by Bomi on 2021/03/25.
 * 문제 출처 : https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Time Complexity : O(N)
 * Used Algorithm : 자료구조
 * Used Data structure : List(LinkedList)
 */

public class Leet160 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA), lengthB = length(headB);
        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }

        while (lengthA < lengthB) {
            headB = headB.next;
            lengthB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }
}
