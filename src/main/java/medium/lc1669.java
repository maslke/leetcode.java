package medium;

// https://leetcode-cn.com/problems/merge-in-between-linked-lists/
// 1669. 合并两个链表

public class lc1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode newHead = new ListNode(0);
        newHead.next = list1;
        ListNode prev = newHead;
        ListNode temp = newHead.next;
        for (int i = 0; i < a; i++) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = list2;

        for (int i = 1; i <= b - a; i++) {
            temp = temp.next;
        }

        // list2 tail
        ListNode prev2 = null;
        ListNode temp2 = list2;
        while (temp2 != null) {
            prev2 = temp2;
            temp2 = temp2.next;
        }
        if (temp != null) {
            prev2.next = temp.next;
        }

        return newHead.next;
    }
}
