package easy;

class lc1290 {
    public int getDecimalValue(ListNode head) {
        int value = 0;
        ListNode temp = head;
        while (temp != null) {
            value = value * 2 + temp.val;
            temp = temp.next;
        }
        return value;
    }
}