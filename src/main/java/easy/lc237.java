package easy;

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 237. Delete Node in a Linked List
 */
public class lc237 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            node = null;
            return;
        }
        ListNode next = node.next;
        ListNode before = node;
        while(next != null) {
            before.val = next.val;
            if (next.next == null) {
                before.next = null;
            } else {
                before = next;
            }
            next = next.next;
        }

    }
}
