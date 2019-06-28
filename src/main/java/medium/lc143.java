package medium;

/**
 * Author:maslke
 * Date:2017/9/29
 * Version:0.0.1
 * 143. Reorder List
 */
public class lc143 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public void reorderList(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length += 1;
        }
        if (length <= 2) {
            return;
        }
        int half = (length + 1) / 2;
        temp = head;
        for (int i = 1; i < half; i++) {
            temp = temp.next;
        }
        ListNode nextHalf = temp.next;
        temp.next = null;
        temp = head;
        int index = length - half;
        half = length % 2 == 0 ? half + 1 : half;
        for (int i = 1; i < half; i++) {
            ListNode next = temp.next;
            ListNode temp3 = nextHalf;
            for (int j= 1; j < index; j++) {
                temp3 = temp3.next;
            }
            temp.next = temp3;
            temp3.next = next;
            temp = next;
            index--;
        }
    }

    public void reorderList3(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        slow = reverse(slow);
        ListNode h = head;

        // h is less or equal to slow in length
        while (h != null) {
            ListNode next = h.next;
            ListNode slow2 = slow.next;
            h.next = slow;
            if (next == null) {
                break;
            } else {
                slow.next = next;
            }

            h = next;
            slow = slow2;
        }        
    }

    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) {
            prev.next = null;
        }
        slow = reverse(slow);
        ListNode h = head;
        while (slow != null) {
            ListNode next = h.next;
            ListNode next2 = slow.next;
            h.next = slow;
            if (next == null) break;
            slow.next = next;
            h = next;
            slow = next2;
        }
        
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode h = head;
        while (h != null) {
            ListNode next = h.next;
            h.next = prev;
            prev = h;
            h = next;
        }
        return prev;
    }
}
