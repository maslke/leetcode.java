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
}

