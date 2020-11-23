package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/3sum/
// 15. 三数之和

public class lc15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == -1 * nums[i]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    ret.add(list);
                    left++;
                    while (left < nums.length - 1 && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                    while (right >= 0 && nums[right] == nums[right + 1]) {
                        right--;
                    }

                }
                else if (sum > -1 * nums[i]) {
                    right--;
                    while (right >= 0 && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
                else {
                    left++;
                    while (left < nums.length - 1 && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return ret;
    }
}
