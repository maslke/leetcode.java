//https://leetcode.com/problems/swap-nodes-in-pairs/
//24. Swap Nodes in Pairs
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode prev = h;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            if (next == null) break;
            ListNode next2 = next.next;
            prev.next = next;
            next.next = current;
            current.next = next2;
            
            prev = current;
            current = next2;
        }
        
        
        return h.next;
    }
}
