package medium;

/**
 * Author:maslke
 * Date:2017/9/30
 * Version:0.0.1
 * 92. Reverse Linked List II
 */
public class lc92 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        if (length == 0) {
            return null;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        m = m <= 0 ? 1: m;
        n = n > length? length: n;
        if (m == n) {
            return head;
        }
        temp = newHead;
        ListNode prev = null;
        for (int i = 0; i < m; i++) {
            prev = temp;
            temp = temp.next;
        }
        ListNode prev2 = temp;
        temp = temp.next;
        for (int i  = 0; i < n - m; i++) {
            ListNode next = temp.next;
            ListNode next2 = prev.next;
            prev.next = temp;
            temp.next = next2;
            temp = next;
            prev2.next = next;
        }
        return newHead.next;

    }


}

