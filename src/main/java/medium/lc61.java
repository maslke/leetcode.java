package medium;

/**
 * Author:maslke
 * Date:2017/9/5
 * Version:0.0.1
 * 61. Rotate List
 */
public class lc61 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        k = k % length;
        temp = head;
        ListNode tail = head;
        for (int i = 0; i < length - k - 1; i++) {
            tail = tail.next;
        }
        for (int i = 0; i < length - 1; i++) {
            temp = temp.next;
        }
        temp.next = head;
        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;
    }
}
