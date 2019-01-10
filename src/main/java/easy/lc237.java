package easy;

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 237. Delete Node in a Linked List
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        ListNode prev = null;
        ListNode h = node;
        while (h != null) {
            ListNode next = h.next;
            if (next == null) break;
            h.val = next.val;
            prev = h;
            h = next; 
        }
        prev.next = null;
    }
}
