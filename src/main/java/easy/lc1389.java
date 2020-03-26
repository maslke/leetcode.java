package easy;

// https://leetcode-cn.com/problems/create-target-array-in-the-given-order/
// 1389. 按既定顺序创建目标数组

class lc1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int inx = index[i];
            int v = nums[i];

            for (int m = nums.length - 2; m >= inx; m--) {
                ret[m + 1] = ret[m];
            }
            ret[inx] = v;
        }

        return ret;
    }
}