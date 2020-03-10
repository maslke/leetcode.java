package easy;

import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
// 1365. How Many Numbers Are Smaller Than the current Number

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int v : nums) {
            map.put(v, map.getOrDefault(v, 0) + 1);
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            map.put(key, count);
            count += value;
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }
}