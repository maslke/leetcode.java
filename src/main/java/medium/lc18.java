package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = target - (nums[i] + nums[j]);

                int begin = j + 1;
                int end = nums.length - 1;
                while (begin < end) {
                    int sum = nums[begin] + nums[end];
                    if (sum == left) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[begin], nums[end]);
                        ret.add(list);
                        int a = nums[end];
                        end--;
                        while (end >= 0 && nums[end] == a) {
                            end--;
                        }
                        int b = nums[begin];
                        begin++;
                        while (begin < nums.length && nums[begin] == b) {
                            begin++;
                        }
                    } else if (sum > left) {
                        end--;
                    } else {
                        begin++;
                    }
                }
            }
        }

        return ret;
    }
}
