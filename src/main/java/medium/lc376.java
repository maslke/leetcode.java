package medium;

// https://leetcode-cn.com/problems/wiggle-subsequence/
// 376. 摆动序列

public class lc376 {
    public int wiggleMaxLength(int[] nums) {

        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int count = 1;
        int first = nums[0];
        int inx = 1;
        while (inx < nums.length && nums[inx] == first) {
            inx++;
        }
        if (inx == nums.length) {
            return count;
        }
        int second = nums[inx];

        count = 2;
        boolean relation = second > first;
        for (int i = 2; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            boolean rela = nums[i] > second;

            if (rela != relation) {
                count++;
                relation = rela;
            }
            second = nums[i];

        }

        return count;
    }
}
