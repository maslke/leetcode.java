package medium;

/**
 * Author:maslke
 * Date:2017/9/29
 * Version:0.0.1
 * 143. Reorder List
 */
public class lc143 {
    class ListNode {
        ListNode next;
        int val;
        ListNode(int x) {
            val = x;
        }
    }
    public void reorderList(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length += 1;
        }
        if (length <= 2) {
            return;
        }
        int half = (length + 1) / 2;
        temp = head;
        for (int i = 1; i < half; i++) {
            temp = temp.next;
        }
        ListNode nextHalf = temp.next;
        temp.next = null;
        temp = head;
        int index = length - half;
        half = length % 2 == 0 ? half + 1 : half;
        for (int i = 1; i < half; i++) {
            ListNode next = temp.next;
            ListNode temp3 = nextHalf;
            for (int j= 1; j < index; j++) {
                temp3 = temp3.next;
            }
            temp.next = temp3;
            temp3.next = next;
            temp = next;
            index--;
        }
    }
}
