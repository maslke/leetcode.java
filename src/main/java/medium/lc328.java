package medium;

/**
 * Author:maslke Date:2017/9/30 Version:0.0.1 328. Odd Even Linked List
 */
public class lc328 {
    class ListNode {
        ListNode next;
        int val;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode odd = head;
        ListNode even = head.next;
        if (even == null) {
            return head;
        }
        ListNode evenHead = even;
        ListNode temp = even.next;
        while (temp != null) {
            ListNode odd1 = temp;
            odd.next = odd1;
            odd = odd.next;
            ListNode even1 = temp.next;
            if (even1 == null) {
                odd.next = evenHead;
                even.next = null;
                break;
            } else {
                even.next = even1;
                even = even1;
            }
            temp = even1.next;
            if (temp == null) {
                odd.next = evenHead;
            }
        }
        return head;
    }

    // a stupid solution
    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode current = head;
        ListNode current2 = head.next;
        int count = 1;
        boolean flag = true;
        while (flag) {
            ListNode c = current2;
            ListNode prev = null;
            for (int i = 1; i <= count; i++) {
                prev = c;
                c = c.next;
                if (c == null) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            ListNode next = c.next;
            current.next = c;
            c.next = current2;
            if (prev == current2) {
                current2.next = next;

            } else {
                prev.next = next;
            }
            count++;
            current = current.next;

        }

        return head;
    }
}
