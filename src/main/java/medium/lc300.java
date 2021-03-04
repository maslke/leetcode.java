package medium;

// https://leetcode.com/problems/longest-increasing-subsequence/
// 300. Longest Increasing Subsequence

import java.util.TreeSet;

// https://leetcode-cn.com/problems/longest-increasing-subsequence/
// 300. 最长递增子序列

class lc300 {

    public int lengthOfLIS2(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    res[i] = Math.max(res[i], res[j]);
                }
            }
            res[i]++;
        }

        int max = 1;
        for (int r : res) {
            max = Math.max(r, max);
        }
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int v : nums) {
            Integer value = set.ceiling(v);
            if (value == null) {
                set.add(v);
            } else {
                set.remove(value);
                set.add(v);
            }
        }
        return set.size();
    }
}