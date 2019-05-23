package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:maslke
 * Date:2017/9/4
 * Version:0.0.1
 * 19. Remove Nth Node From End of List
 */
public class lc19 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n == 0) {
            return head;
        }
        ListNode temp = head;
        List<ListNode> list = new ArrayList<ListNode>();
        while (temp != null) {
            list.add(temp);
            temp = temp.next;
        }
        int length = list.size();
        if (n == length) {
            return head.next;
        }
        if (n == 1) {
            list.get(length - 2).next = null;
        } else {
            list.get(length - n - 1).next = list.get(length - n + 1);
        }
        return head;
    }

    //solution2
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        if (n == 0) return head;
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode c = current;
            for (int i = 0; i < n; i++) {
                c = c.next;
            }
            if (c == null) {
                if (prev == null) {
                   return head.next;
                } else {
                    prev.next = current.next;
                    break;
                }
            } else {
                prev = current;
                current = current.next;
            }
        }
        return head;
        
    }

    //solution3
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        int count = 0;
        ListNode h = head;
        while (h != null) {
            count++;
            h = h.next;
        }
        h = head;
        for (int i = 0; i < count - n - 1; i++) {
            h = h.next;
        }
        if (n == count) {
            return head.next;
        } else {
            ListNode next = h.next.next;
            h.next = next;
            return head;
        }
    }
}
