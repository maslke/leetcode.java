package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode-cn.com/problems/increasing-subsequences/
// 491. 递增子序列

public class lc491 {
    Set<List<Integer>> res;

    List<List<Integer>> ret;
    List<Integer> list;

    public List<List<Integer>> findSubsequences2(int[] nums) {
        ret = new ArrayList<>();
        list = new ArrayList<>();
        visit(nums, 0, Integer.MIN_VALUE);
        return ret;
    }

    private void visit(int[] nums, int current, int prev) {
        if (current == nums.length) {
            if (list.size() >= 2) {
                ret.add(new ArrayList<>(list));
            }
            return;
        }
        if (nums[current] >= prev) {
            list.add(nums[current]);
            visit(nums, current + 1, nums[current]);
            list.remove(list.size() - 1);
        }
        if (nums[current] != prev) {
            visit(nums, current + 1, nums[current]);
        }
    }





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
