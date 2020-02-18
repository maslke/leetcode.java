package medium;

// https://leetcode-cn.com/problems/design-phone-directory/
// 379. 电话目录管理系统

class PhoneDirectory {

    private int count = 0;
    private int length = 0;
    private ListNode h;
    private ListNode tail;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        count = maxNumbers;
        h = new ListNode(-1);
        tail = h;
        length = 0;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (length == count) {
            ListNode temp = h.next;
            int cnt = 0;
            while (temp != null) {
                if (temp.val == -1) {
                    temp.val = cnt;
                    return cnt;
                }
                cnt++;
                temp = temp.next;
            }
            return -1;
        } else {
            tail.next = new ListNode(length);
            tail = tail.next;
            return length++;
        }
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        ListNode temp = h.next;
        int cnt = 0;
        while (temp != null) {
            if (cnt == number) {
                return temp.val == -1;
            }
            cnt++;
            temp = temp.next;
        } 
        return true;   
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        ListNode temp = h.next;
        int cnt = 0;
        while (temp != null) {
            if (cnt == number) {
                temp.val = -1;
                break;
            }
            cnt++;
            temp = temp.next;
        }
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */