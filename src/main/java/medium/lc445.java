package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:maslke
 * Date:2017/8/26
 * Version:0.0.1
 * 445. Add Two Numbers II
 */
public class lc445 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }

    //a better solution
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
          ListNode l3 = revert(l1);
          ListNode l4 = revert(l2);
          return revert(add(l3, l4));  
    }

    private ListNode revert(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = head;
        ListNode before = null;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = before;
            before = temp;
            if (next == null) {
                break;
            }
            temp = next;
        }
        return before;
    }

    private ListNode add(ListNode l1, ListNode l2) {
        boolean flag = false;
        ListNode newHead = new ListNode(0);
        ListNode cursor = newHead;
        while (l1 != null || l2 != null) {
            int v = 0;
            if (l1 != null) {
                v += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
               v += l2.val;
               l2 = l2.next;     
            }

            if (flag) {
                v += 1;
                flag = false;
            }
            if (v >= 10) {
                v -= 10;
                flag = true;
            }
            ListNode node = new ListNode (v);
            cursor.next = node;
            cursor = node;
         }    
         if (flag) {
             cursor.next = new ListNode(1);
         }
        return newHead.next;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int len1 = 0, len2 = 0;
        ListNode temp = l1;
        while(temp != null) {
            len1++;
            temp = temp.next;
        }
        temp = l2;
        while(temp != null) {
            len2++;
            temp = temp.next;
        }
        int diff = 0;
        ListNode newL1 = l1, newL2 = l2;
        List<ListNode> list = new ArrayList<ListNode>();
        if (len1 > len2) {
            diff = len1 - len2;
            for (int i = 0; i < diff; i++) {
                list.add(new ListNode(newL1.val));
                newL1 = newL1.next;
            }
        }
        if (len1 < len2) {
            diff = len2 - len1;
            for (int i = 0; i < diff; i++) {
                list.add(new ListNode(newL2.val));
                newL2 = newL2.next;
            }
        }
        while(newL1 != null) {
            list.add(new ListNode(newL1.val + newL2.val));
            newL1 = newL1.next;
            newL2 = newL2.next;
        }

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        int i = list.size() - 1;
        boolean flag = false;
        while(i >= 0) {
            int val = list.get(i).val;
            if (flag) {
                val += 1;
                flag = false;
            }
            if (val >= 10) {
                val -= 10;
                flag = true;
            }
            list.get(i).val = val;
            i--;
        }
        if (flag) {
            list.add(0, new ListNode(1));
            list.get(0).next = list.get(1);
        }
        return list.get(0);
    }
}
