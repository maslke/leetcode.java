package easy;

/**
 * Author:maslke
 * Date:2017/8/28
 * Version:0.0.1
 * 160. Intersection of Two Linked Lists
 */
public class lc160 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 0;
        int lenB = 0;
        ListNode tempA = headA, tempB = headB;
        while(tempA != null) {
            lenA++;
            tempA = tempA.next;
        }
        while(tempB != null) {
            lenB++;
            tempB = tempB.next;
        }
        tempA = headA;
        tempB =headB;
        if (lenA > lenB) {
            for(int i = 0; i < lenA - lenB; i++) {
                tempA = tempA.next;
            }
        } else if (lenB > lenA) {
            for (int i = 0; i < lenB - lenA; i++) {
                tempB = tempB.next;
            }
        }
        while(tempA != null) {
            if (tempA == tempB) {
                return tempA;
            } else {
                tempA = tempA.next;
                tempB = tempB.next;
            }
        }
        return null;
    }
}
