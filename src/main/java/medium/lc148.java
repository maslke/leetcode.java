/**
 * https://leetcode.com/problems/sort-list/
 * 148. Sort List
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        ListNode flag = new ListNode(0);
        ListNode current = head.next;
        flag.next = head;
        head.next = null;
        while (current != null) {
            ListNode temp = flag.next;
            ListNode prev = null;
            while (temp != null) {
                if (temp.val >= current.val) {
                    break;
                } else {
                    prev = temp;
                    temp = temp.next;
                }
            }
            if (temp == null) {
                prev.next = current;
                current = current.next; 
                prev.next.next = null;
            } else {
                ListNode temp2 = current.next;
                if (prev == null) {
                    prev = flag;
                }
                prev.next = current;
                current.next = temp;
                current = temp2;
            }
        }
        return flag.next;
    }
}