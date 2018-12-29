/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;
        int len = 0;
        ListNode h = head;
        while (h != null) {
            len++;
            h = h.next;
        }
    
        h = head;
        for (int i = 0; i < len / 2 ; i++) {
            h = h.next;
        }
        return h;
        
        
    }
}