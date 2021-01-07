package medium;

// https://leetcode-cn.com/problems/check-if-all-1s-are-at-least-length-k-places-away/
// 1437. 是否所有1都至少相隔k个元素

public class lc1437 {
    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) {
            return true;
        }
        int left = -1;
        int i = 0;
        while (i < nums.length && nums[i] != 1) {
            i++;
        }
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == 1) {
                if (j - i <= k) {
                    return false;
                }
                i = j;
            }
        }
        return true;
    }
}
