package easy;

/**
 * Author:maslke
 * Date:2017/8/27
 * Version:0.0.1
 */
public class lc234 {

    class ListNode {
        ListNode next;
        int val;
        ListNode (int x) {
            val = x;
        }
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode temp = head;
        int len = 0;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        int half = len / 2;
        ListNode prev = head;
        temp = head;
        for (int i = 0; i < half; i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        prev = null;
        while (temp != null) {
            ListNode temp2 = temp.next;
            temp.next = prev;
            prev = temp;
            temp = temp2;
        }
        temp = prev;
        ListNode temp3 = head;
        for (int i = 0; i < half; i++) {
            if (temp3.val != temp.val) {
                return false;
            }
            temp3  = temp3.next;
            temp = temp.next;

        }
        return true;
    }

    //a better solution
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        fast = head;
        slow = reverse(slow);
        while (fast != null || slow != null) {
            if (fast == null || slow == null) {
                return true;
            }
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
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


