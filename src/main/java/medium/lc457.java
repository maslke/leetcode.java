package medium;

import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/circular-array-loop/
// 457. 环形数组是否存在循环

public class lc457 {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean positive = nums[i] > 0;

            Set<Integer> set = new HashSet<>();
            set.add(i);
            int temp = i;
            int prev = i;
            while (true) {
                int inx = ((temp + nums[temp]) % nums.length + nums.length) % nums.length;
                if (positive != (nums[inx] > 0)) {
                    break;
                }
                if (set.contains(inx)) {
                    if (set.size() > 1 && prev != inx) {
                        return true;
                    }
                    else {
                        break;
                    }
                }
                else {
                    prev = inx;
                    temp = inx;
                    set.add(inx);
                }
            }
        }
        return false;
    }

    // a much better
    public boolean circularArrayLoop2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            int slow = i;
            int fast = next(nums, i);
            // 同方向
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow == next(nums,slow)) {
                        break;
                    }
                    return true;
                }
                slow = next(nums,slow);
                fast = next(nums, next(nums, fast));
            }
            slow = i;

            // 遍历过的数据都设置为0
            // 标记
            while (nums[slow] > 0 && nums[next(nums, slow)] > 0) {
                int temp = slow;
                slow = next(nums, slow);
                nums[temp] = 0;
            }
        }
        return false;

    }

    private int next(int[] nums, int inx) {
        int n = nums.length;
        return ((inx + nums[inx]) % n + n) % n;
    }
}
