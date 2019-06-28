package hard;

// https://leetcode.com/problems/reverse-nodes-in-k-group/
// 25. Reverse Nodes in k-Group

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class ListNode {
    ListNode next;
    int val;

    ListNode(int val) {
        this.val = val;
    }
}

public class lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;
        int i = 0;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        while (true) {
            boolean flag = reverse(newHead, k * i + 1, k * i + k);
            if (!flag)
                break;
            i++;
        }
        return newHead.next;
    }

    private ListNode revert(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    private boolean reverse(ListNode head, int m, int n) {
        ListNode prev = head;
        ListNode temp = head.next;
        for (int i = 0; i < m; i++) {
            prev = temp;
            temp = temp.next;
            if (temp == null)
                return false;
        }

        ListNode temp2 = head.next;
        for (int i = 0; i < n; i++) {
            temp2 = temp2.next;
            if (temp2 == null)
                return false;
        }

        ListNode after = temp2.next;
        temp2.next = null;

        prev.next = revert(temp);
        temp.next = after;

        return true;
    }
}