package medium;

// https://leetcode.com/problems/split-linked-list-in-parts/
// 725. Split Linked List in Parts

class lc725 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode temp = root;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        ListNode[] result = new ListNode[k];
        int index = 0;
        temp = root;
        while (true) {
            int count;
            if (length <= k) {
                count = index >= length ? 0 : 1;
            } else {
                if (index < length % k) {
                    count = length / k + 1;
                } else {
                    count = length / k;
                }
                ListNode prev = null;    
                for (int i = 0; i < count; i++) {
                    if (result[index] == null) {
                        result[index] = temp;
                    }
                    prev = temp;
                    if (temp != null) {
                        temp = temp.next;
                    }  
                }
                if (prev != null) {
                    prev.next = null;
                }
                index++;
                if (index >= k) break;
            }
        }

        return result;
    }
}