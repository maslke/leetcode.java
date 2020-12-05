package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/combination-sum-ii/
// 40. 组合总数 II

public class lc40 {
    private List<List<Integer>> ret;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ret = new ArrayList<>();
        Arrays.sort(candidates);
        combina(candidates, 0, target, new ArrayList<>());
        return ret;
    }

    private void combina(int[] nums, int begin, int target, List<Integer> list) {
        if (target == 0) {
            ret.add(new ArrayList<>(list));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            if (target - nums[i] < 0) {
                continue;
            }
            list.add(nums[i]);
            combina(nums, i + 1, target - nums[i], list);
            list.remove(list.size() - 1);
        }
    }
}
