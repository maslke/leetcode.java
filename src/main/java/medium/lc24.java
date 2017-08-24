package medium;

/**
 * Author:maslke
 * Date:2017/8/24
 * Version:0.0.1
 * 24. Swap Nodes in Pairs
 */
public class lc24 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;
        while(current != null) {
            ListNode node1 = current.next;
            if (node1 == null) {
                break;
            }
            ListNode node2 = node1.next;
            if (node2 == null) {
                break;
            }
            ListNode change = node2.next;
            node2.next =node1;
            current.next = node2;
            node1.next = change;

            current = node1;
        }
        return temp.next;
    }
}
