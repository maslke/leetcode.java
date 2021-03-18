package medium;

// https://leetcode-cn.com/problems/reverse-linked-list-ii/
// 92. 反转链表 II

public class lc92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
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
}
