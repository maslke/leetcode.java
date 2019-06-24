package medium;

/**
 * Author:maslke
 * Date:2017/9/12
 * Version:0.0.1
 * 142. Linked List Cycle II
 */
public class lc142 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != null && fast != null) {
                    if (slow == fast) {
                        return slow;
                    }
                    slow = slow.next;
                    fast = fast.next;
                }
            }
        }
        return null;
    }

    /**
     * 2018/12/28
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null) return head;
        ListNode h1 = head;
        ListNode h2 = head;
        ListNode pos = null;
        while (h1 != null && h2 != null) {
            h1 = h1.next;
            h2 = h2.next;
            if (h1 == null || h2 == null) {
                pos = null;
                break;
            }
            h2 = h2.next;
            if (h2 == null) {
                pos = null;
                break;
            }
            if (h1 == h2) {
                pos = h1;
                break;
            }
        }
        if (pos == null) return null;
        h1 = head;
        h2 = pos;
        while (h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1;
    }
}
