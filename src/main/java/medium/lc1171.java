package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
// 1171. Remove Zero Sum Consecutive Nodes from Linked List

class lc1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int i = 0;
        while (i < list.size()) {
            int sum = 0;
            int j = i;
            while (j >= 0) {
                sum += list.get(j);
                if (sum == 0) {
                    break;
                }
                j--;
            }
            if (j < 0) {
                i++;
            } else {
                for (int m = 1; m <= i - j + 1; m++) {
                    list.remove(j);
                }
                i = j;
            }
        }

        if (list.isEmpty()) return null;
        ListNode root = new ListNode(list.get(0));
        temp = root;
        for (int m = 1; m < list.size(); m++) {
            ListNode newNode = new ListNode(list.get(m));
            temp.next = newNode;
            temp = newNode;
        }
        return root;
    }
}