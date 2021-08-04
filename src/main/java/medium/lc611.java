package medium;

import java.util.Arrays;

// https://leetcode-cn.com/problems/valid-triangle-number/
// 611. 有效三角形的个数

class lc611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {

                int low = j + 1;
                int high = nums.length - 1;

                int sum = nums[i] + nums[j];
                int p = -1;
                while (low <= high) {

                    int m = (high - low) / 2 + low;
                    if (nums[m] >= sum) {
                        high = m - 1;
                        p = m;
                    } else {
                        low = m + 1;
                    }

                }

                if (p == -1) {
                    ret += nums.length - j - 1;
                } else {
                    ret += p - j - 1;
                }
            }
        }

        return ret;
    }

    public int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;

        for (int i = 0; i < nums.length; i++) {
            int k = i;
            for (int j = i + 1; j < nums.length; j++) {
                while (k + 1 < nums.length && nums[i]+ nums[j] > nums[k + 1]) {
                    k++;
                }
                ret += Math.max(k - j, 0);

            }
        }

        return ret;
    }
}