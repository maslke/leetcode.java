// https://leetcode.com/problems/merge-k-sorted-lists/
// 23. Merge k Sorted Lists

package hard;

import basic.ListNode;

import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

public class lc23 {

    public ListNode mergeKLists4(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) return null;
        int interval = 1;
        while (interval < len) {
            for (int i = 0; i + interval < len; i = i + 2 * interval) {
                lists[i] = merge(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });

        for (ListNode list : lists) {
            if (list != null) {
                queue.add(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            temp.next = node;
            temp = temp.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return head.next;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        int len = lists.length;
        ListNode result = null;
        int i = 0;
        while (true) {
            if (i >= len)
                break;
            if (i == 0) {
                result = lists[0];
            } else {
                result = merge(result, lists[i]);
            }
            i++;
        }
        return result;
    }

    private ListNode merge(ListNode headA, ListNode headB) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null || tempB != null) {
            if (tempA != null && tempB != null) {
                if (tempA.val < tempB.val) {
                    temp.next = tempA;
                    tempA = tempA.next;
                    temp = temp.next;
                } else {
                    temp.next = tempB;
                    tempB = tempB.next;
                    temp = temp.next;
                }
            } else if (tempA != null) {
                temp.next = tempA;
                break;
            } else {
                temp.next = tempB;
                break;
            }
        }
        return newHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;
        while (true) {
            int index = -1;
            ListNode node = null;
            for (int i = 0; i < lists.length; i++) {
                if (node == null) {
                    node = lists[i];
                    index = i;
                } else {
                    if (lists[i] == null)
                        continue;
                    if (node.val > lists[i].val) {
                        node = lists[i];
                        index = i;
                    }
                }
            }
            if (node == null)
                break;
            temp.next = node;
            lists[index] = lists[index].next;
            temp = node;
        }
        return newHead.next;
    }
}