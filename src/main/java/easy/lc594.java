package easy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/longest-harmonious-subsequence/
// 594. Longest Harmonious Subsequence

class lc594 {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        Map.Entry<Integer, Integer> one = null;
        int length = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (one == null) {
                one = entry;
            } else {
                if (entry.getKey() - one.getKey() == 1) {
                    length = Math.max(length, entry.getValue() + one.getValue());
                }
                one = entry;
            }
        }
        return length;
    }

    public int findLHS2(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        int i = 0;
        int j = nums.length;
        while (i < j) {
            int m = i;
            int v = nums[i];
            while (m < j) {
                if (nums[m] - v <= 1) {
                    m++;
                } else {
                  break;
                }
            }
            if (nums[m - 1] != v) {
                ret = Math.max(ret, m - i);
            }
            
            if(m < j && nums[m] - v > 2) {
                i = m;
            } else {
                i = i + 1;
            }
            
        }
        return ret;
    }
}