package medium;

// https://leetcode-cn.com/problems/grumpy-bookstore-owner/
// 1052. 爱生气的书店老板

public class lc1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0;
        int left = 0;
        int right = 0;
        int len = grumpy.length;
        int no = 0;
        for (int i = 0; i < X; i++) {
            if (grumpy[i] == 0) {
                sum += customers[i];
            }
            else {
                no += customers[i];
            }
        }
        right = X;
        int max = no;
        while (right < len) {
            if (grumpy[right] == 1) {
                no += customers[right];
            }
            else {
                sum += customers[right];
            }
            if (grumpy[left] == 1) {
                no -= customers[left];
            }
            right++;
            left++;
            max = Math.max(max, no);
        }
        return sum + max;
    }
}
