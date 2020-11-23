package medium;

// https://leetcode-cn.com/problems/3sum-closest/
// 16. 最接近的三数之和

import java.util.Arrays;

public class lc16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ret = 10000;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target - nums[i]) {
                    return target;
                }
                if (Math.abs(ret - target) > Math.abs(sum + nums[i] - target)) {
                    ret = sum + nums[i];
                }
                if (sum > target - nums[i]) {
                    right--;
                    while (right >= 0 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else {
                    left++;
                    while (left <= nums.length - 1 && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return ret;
    }
}
