package medium;

// https://leetcode.com/problems/longest-increasing-subsequence/
// 300. Longest Increasing Subsequence

import java.util.TreeSet;

class lc300 {
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