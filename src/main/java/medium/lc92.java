package medium;

/**
 * Author:maslke Date:2017/9/30
 * Version:0.0.1 92.
 * Reverse Linked List II
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
        m = m <= 0 ? 1 : m;
        n = n > length ? length : n;
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
        for (int i = 0; i < n - m; i++) {
            ListNode next = temp.next;
            ListNode next2 = prev.next;
            prev.next = temp;
            temp.next = next2;
            temp = next;
            prev2.next = next;
        }
        return newHead.next;

    }

    // solution 2
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null)
            return head;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode current = head;
        ListNode prev = h;
        for (int i = 1; i < m; i++) {
            prev = current;
            current = current.next;
        }
        ListNode current2 = current;
        ListNode next = current.next;
        for (int i = m; i < n; i++) {
            ListNode temp = next.next;
            next.next = current;
            current = next;
            next = temp;
        }

        prev.next = current;
        current2.next = next;

        return h.next;
    }

    // solution 3
    public ListNode reverseBetween3(ListNode head, int m, int n) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode prev = null;
        ListNode temp = h;
        for (int i = 0; i < m; i++) {
            prev = temp;
            temp = temp.next;

        }
        ListNode temp2 = temp;
        for (int i = m; i < n; i++) {
            temp2 = temp2.next;
        }
        ListNode tail = temp2.next;
        temp2.next = null;
        prev.next = reverse(temp);
        temp.next = tail;
        return h.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode h = node;
        while (h != null) {
            ListNode next = h.next;
            h.next = prev;
            prev = h;
            h = next;

        }
        return prev;
    }

}
