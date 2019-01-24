package easy;

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 203. Remove Linked List Elements
 */
public class lc203 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        ListNode next = prev.next;
        while(next != null) {
            if (next.val == val) {
                prev.next = next.next;
                next = next.next;
            } else {
                prev = next;
                next = next.next;
            }
        }
        return temp.next;
    }

    //recursive
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            remove(head, head.next, val);
            return head;
        }
    }
    
    private void remove(ListNode prev, ListNode current, int val) {
        if (current == null) return;
        if (current.val == val) {
            prev.next = current.next;
            remove(prev, current.next, val);
        } else {
            remove(current, current.next, val);
        }
    }
}
