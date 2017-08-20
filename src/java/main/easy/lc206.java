package main.easy;

/**
 * Author:maslke
 * Date:2017/8/20
 * Version:0.0.1
 * 206. Reverse Linked List
 */
public class lc206 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int i) {
            val = i;
        }
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        head.next = null;
        return reverse(head, next);
    }

    private ListNode reverse(ListNode node, ListNode other) {
        if (other == null) {
            return node;
        }
        ListNode next = other.next;
        other.next = node;
        return reverse(other, next);
    }
}
