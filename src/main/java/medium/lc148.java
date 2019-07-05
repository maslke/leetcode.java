package medium;

/**
 * https://leetcode.com/problems/sort-list/ 148. Sort List Definition for
 * singly-linked list. public class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; } }
 */
class lc148 {

    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = middle(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode n1 = sortList2(head);
        ListNode n2 = sortList2(next);
        return sort(n1, n2);
    }

    private ListNode middle(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }

    private ListNode sort(ListNode headA, ListNode headB) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null || tempB != null) {
            if (tempA != null && tempB != null) {
                if (tempA.val < tempB.val) {
                    temp.next = tempA;
                    tempA = tempA.next;
                    temp = temp.next;
                } else {
                    temp.next = tempB;
                    tempB = tempB.next;
                    temp = temp.next;
                }
            } else if (tempA != null) {
                temp.next = tempA;
                break;
            } else {
                temp.next = tempB;
                break;
            }
        }
        return head.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null)
            return head;
        ListNode flag = new ListNode(0);
        ListNode current = head.next;
        flag.next = head;
        head.next = null;
        while (current != null) {
            ListNode temp = flag.next;
            ListNode prev = null;
            while (temp != null) {
                if (temp.val >= current.val) {
                    break;
                } else {
                    prev = temp;
                    temp = temp.next;
                }
            }
            if (temp == null) {
                prev.next = current;
                current = current.next;
                prev.next.next = null;
            } else {
                ListNode temp2 = current.next;
                if (prev == null) {
                    prev = flag;
                }
                prev.next = current;
                current.next = temp;
                current = temp2;
            }
        }
        return flag.next;
    }
}