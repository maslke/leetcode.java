
/**
 * Author:maslke
 * Date:2017/8/25 
 * Version:0.0.1 2. 
 * Add Two Numbers
 */
public class lc2 {
    class ListNode {
        ListNode next;
        int val;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        boolean flag = false;
        ListNode h = head;
        while (l1 != null || l2 != null) {
            int val = 0;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }
            if (flag) {
                val += 1;
                flag = false;
            }
            if (val >= 10) {
                val -= 10;
                flag = true;
            }
            ListNode node = new ListNode(val);
            h.next = node;
            h = node;
        }
        if (flag) {
            h.next = new ListNode(1);
        }
        return head.next;
    }
}
