package easy;

/**
 * Author:maslke
 * Date:2017/8/25
 * Version:0.0.1
 * 2. Add Two Numbers
 */
public class lc2 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp = new ListNode(0);
        ListNode cur = temp;
        boolean flag = false;
        while(temp1 != null && temp2 != null) {
            int sum = temp1.val + temp2.val;
            if (flag) {
                sum +=1;
            }
            if (sum >= 10) {
                sum -= 10;
                flag = true;
            } else {
                flag = false;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        ListNode temp3 = null;
        if (temp1 == null && temp2 == null) {
            if (flag) {
                cur.next = new ListNode(1);
                flag = false;
            }
        } else if (temp1 != null) {
            temp3 = temp1;
        } else {
            temp3 = temp2;
        }
        while(temp3 != null) {
            int sum = temp3.val;
            if (flag) {
                sum +=1;
            }
            if (sum >= 10) {
                sum -= 10;
                flag = true;
            } else {
                flag = false;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
            temp3 = temp3.next;
        }
        if (flag) {
            cur.next = new ListNode(1);
            flag = false;
        }

        return temp.next;
    }
}
