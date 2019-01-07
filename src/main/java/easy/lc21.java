
/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 21. Merge Two Sorted Lists
 */
public class lc21 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode cur = temp;
        while(temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                cur.next = new ListNode(temp1.val);
                temp1 = temp1.next;
            } else {
                cur.next = new ListNode(temp2.val);
                temp2 = temp2.next;
            }
            cur = cur.next;
        }
        ListNode temp3 = null;
        if (temp1 != null) {
            temp3 = temp1;
        } else if (temp2 != null) {
            temp3 = temp2;
        }
        while(temp3 != null) {
            cur.next = new ListNode(temp3.val);
            temp3 = temp3.next;
            cur = cur.next;
        }
        return temp.next;
    }
}

//simplify the solution
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode cur = temp;
        while(temp1 != null || temp2 != null) {
            if (temp1 == null) {
                cur.next = new ListNode(temp2.val);
                temp2 = temp2.next;
            } else if (temp2 == null) {
                cur.next = new ListNode(temp1.val);
                temp1 = temp1.next;
            } else {
                if (temp1.val < temp2.val) {
                cur.next = new ListNode(temp1.val);
                temp1 = temp1.next;
            } else {
                cur.next = new ListNode(temp2.val);
                temp2 = temp2.next;
            }
            }
            
            cur = cur.next;
        }
        return temp.next;
    }
}
