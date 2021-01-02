package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/combination-sum/
// 39. 组合总数

public class lc39 {
    private List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combine(candidates, 0, target, new ArrayList<>());
        return ret;
    }

    private void combine(int[] nums, int begin, int sum, List<Integer> list) {
        if (sum == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            if (sum - nums[i] < 0) {
                continue;
            }
            list.add(nums[i]);
            combine(nums, i, sum - nums[i], list);
            list.remove(list.size() - 1);
        }
    }
}
