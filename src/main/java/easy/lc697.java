package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode-cn.com/problems/degree-of-an-array/
// 697. 数组的度
public class lc697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            max = Math.max(max, list.size() + 1);
            list.add(i);
            map.put(num, list);
        }

        int min = nums.length;
        for (List<Integer> list : map.values()) {
            if (list.size() == max) {
                min = Math.min(min, list.get(list.size() - 1) - list.get(0) + 1);
            }
        }
        return min;
    }
}
