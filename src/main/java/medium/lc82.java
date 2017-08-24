package medium;

/**
 * Author:maslke
 * Date:2017/8/24
 * Version:0.0.1
 * 82. Remove Duplicates from Sorted List II
 */
public class lc82 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        ListNode next = prev.next;
        while(next != null) {
            if (next.next != null) {
                int val = next.val;
                if (next.next.val == val) {
                    while(next != null) {
                        if (next.val == val) {
                            next = next.next;
                        } else {
                            break;
                        }
                    }
                    if (next != null) {
                        prev.next = next;
                    } else {
                        prev.next = null;
                        break;
                    }

                } else {
                    prev = next;
                    next = next.next;
                }
            } else {
                break;
            }

        }
        return temp.next;
    }
}
