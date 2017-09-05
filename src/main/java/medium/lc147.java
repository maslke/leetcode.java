package medium;

/**
 * Author:maslke
 * Date:2017/9/5
 * Version:0.0.1
 * 147. Insertion Sort List
 */
public class lc147 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head.next;
        ListNode newHead = head;
        newHead.next = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = null;
            newHead = insertion(newHead, temp);
            temp = next;
        }
        return newHead;
    }

    private ListNode insertion(ListNode head, ListNode node) {
        ListNode prev = null, temp = head;
        while (temp != null) {
            if (temp.val < node.val) {
                prev = temp;
                temp = temp.next;
            } else {
                if (prev == null) {
                    node.next = temp;
                    return node;
                } else {
                    prev.next = node;
                    node.next = temp;
                    return head;
                }
            }
        }
        if (temp == null) {
            prev.next = node;
        }
        return head;
    }
}
