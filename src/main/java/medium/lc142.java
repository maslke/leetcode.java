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
}
