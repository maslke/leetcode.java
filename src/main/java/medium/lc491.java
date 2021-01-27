package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode-cn.com/problems/increasing-subsequences/
// 491. 递增子序列

public class lc491 {
    Set<List<Integer>> res;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited.contains(nums[i])) {
                continue;
            }
            visited.add(nums[i]);
            visit(nums, i, new ArrayList<>());
        }
        return new ArrayList<>(res);
    }

    private void visit(int[] nums, int begin, List<Integer> list) {
        list.add(nums[begin]);
        if (list.size() >= 2) {
            res.add(list);
        }
        for (int i = begin + 1; i < nums.length; i++) {
            if (nums[i] >= nums[begin]) {
                visit(nums, i, new ArrayList<>(list));
            }
        }
    }
}
