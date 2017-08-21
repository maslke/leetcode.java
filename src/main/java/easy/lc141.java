package easy;

/**
 * Author:maslke
 * Date:2017/8/21
 * Version:0.0.1
 * 141. Linked List Cycle
 */
public class lc141 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int i) {
            val = i;
        }
    }
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode n1 = head;
        ListNode n2 = n1.next;
        while (true) {
            if (n1 == null || n2 == null || n1.next == null || n2.next == null || n2.next.next == null) {
                return false;
            }
            if (n1 == n2) {
                return true;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
    }
}
