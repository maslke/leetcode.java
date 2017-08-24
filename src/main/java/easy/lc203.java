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
}
