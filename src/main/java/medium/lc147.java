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

    // a new solution
    public ListNode insertionSortList2(ListNode head) {
        if (head == null) return null;
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode cur = head.next;
        head.next = null;
        ListNode prev2 = head;
        while (cur != null) {
            ListNode prev = h;
            ListNode current = h.next;
            while (current != null) {
                if (current.val <= cur.val) {
                    prev = current;
                    current = current.next;
                } else {
                    break;
                }
            }
            if (current == null) {
                prev.next = cur;
                prev2 = cur;
                cur = cur.next;
                prev2.next = null;
            } else {
                ListNode temp = cur.next;
                prev.next = cur;
                cur.next = current;
                cur = temp;
            }
            
        }
        return h.next;
    }
}
