package medium;

/**
 * Author:maslke
 * Date:2017/10/2
 * Version:0.0.1
 * 86. Partition List
 */
public class lc86 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(x - 1);
        ListNode temp = head;
        ListNode prev = newHead;
        ListNode great = null;
        while (temp != null) {
            ListNode next = temp.next;
            int val = temp.val;
            if (val < x) {
                ListNode prevNext = prev.next;
                prev.next = temp;
                temp.next = prevNext;
                prev = temp;
            } else {
                if (great == null) {
                    prev.next = temp;
                    great = temp;
                    temp.next = null;
                } else {
                    great.next = temp;
                    temp.next = null;
                    great = temp;
                }
            }
            temp = next;
        }
        return newHead.next;
    }

    // a much easier solution
    public ListNode partiton2(ListNode head, int x) {
        ListNode h1 = new ListNode(0);
        ListNode h2 = new ListNode(0);
        ListNode temp1 = h1;
        ListNode temp2 = h2;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            if (temp.val < x) {
                temp1.next = temp;
                temp.next = null;
                temp1 = temp1.next;
            } else {
                temp2.next = temp;
                temp.next = null;
                temp2 = temp2.next;
            }
            temp = next;
        }        
        temp1.next = h2.next;
        return h1.next;
    }
}
