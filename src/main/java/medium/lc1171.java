package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
// 1171. Remove Zero Sum Consecutive Nodes from Linked List

class lc1171 {


    // a much better solution
    public ListNode removeZeroSumSublists2(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode node = h;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        while (node != null) {
            sum += node.val;
            map.put(sum, node);
            node = node.next;
        }
        node = h;
        sum = 0;
        while (node != null) {
            sum += node.val;
            node.next = map.get(sum).next;
            node = node.next;
        }
        return h.next;    
    }


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