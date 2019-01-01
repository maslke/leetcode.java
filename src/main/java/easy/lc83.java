/**
 * Author:maslke
 * Date:2017/8/24
 * Version:0.0.1
 * 83. Remove Duplicates from Sorted List
 */
public class lc83 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        int cur = head.val;
        ListNode before = head;
        ListNode node = head.next;
        while(node != null) {
            if (node.val == cur) {
                before.next = node.next;
                node = node.next;
            } else {
                cur = node.val;
                before = node;
                node = node.next;
            }
        }
        return head;
    }
}
