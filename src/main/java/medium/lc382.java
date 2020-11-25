package medium;

import java.util.Random;

class lc382 {

    private ListNode h;
    private Random random;
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public lc382(ListNode head) {
        this.h = head;
        this.random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count = 1;
        ListNode result = null;
        ListNode temp = h;
        while (temp != null) {
            if (this.random.nextInt(count++) == 0) {
                result = temp;
            }
            temp = temp.next;
        }
        return result.val;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */