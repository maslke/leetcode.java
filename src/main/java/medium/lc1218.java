package medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference/
// 1218. 最长定差子序列
public class lc1218 {
    public int longestSubsequence(int[] arr, int difference) {

        int n = arr.length;
        int[] dp = new int[n];

        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr) {
            map.put(a, map.getOrDefault(a - difference, 0) + 1);
        }

        int ret = 1;
        for (int v : map.values()) {
            ret = Math.max(ret, v);
        }
        return ret;
    }
}
