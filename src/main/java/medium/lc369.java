package medium;

// https://leetcode-cn.com/problems/plus-one-linked-list/
// 369. 给单链表加一
class lc369 {
    public ListNode plusOne(ListNode head) {
        ListNode h = reverse(head);
        ListNode temp = h;
        int val = 1;
        while (val == 1 && temp != null) {
            int v = temp.val + val;
            if (v < 10) {
                temp.val = v;
                val = 0;
            } else {
                temp.val = v - 10;
                temp = temp.next;
                val = 1;
            }
        }

        h = reverse(h);
        if (val == 1) {
            ListNode newHead = new ListNode(1);
            newHead.next = h;
            return newHead;
        } else {
            return h;
        }

           
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}