package medium;

// https://leetcode.com/problems/split-linked-list-in-parts/
// 725. Split Linked List in Parts

class lc725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode cursor = head;
        int len = 0;
        while (cursor != null) {
            len++;
            cursor = cursor.next;
        }
        int cnt = len / k;
        int left = len % k;

        ListNode[] ret = new ListNode[k];
        cursor = head;

        for (int i = 0; i < k; i++) {
            int times = cnt;
            if (left > 0) {
                times++;
                left--;
            }

            ListNode h = cursor;
            ret[i] = h;
            ListNode prev = null;
            while (times > 0 && cursor != null) {
                times--;
                prev = cursor;
                cursor = cursor.next;
            }
            if (prev != null) {
                prev.next = null;
            }
        }

        return ret;
    }
}