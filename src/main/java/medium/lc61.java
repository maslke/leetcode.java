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
        if (head == null || k == 0) return head;
        int len = 0;
        ListNode h = head;
        ListNode prev = null;
        while (h != null) {
            len++;
            prev = h;
            h = h.next;
        }
        k = k % len;
        if (k == 0) return head;
        int m = 0;
        h = head;
        while (m < len - k - 1) {
            h = h.next;
            m++;
        }
        
        ListNode temp = h.next;
        prev.next = head;
        h.next = null;
        return temp;
    }
}
