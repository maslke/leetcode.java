package medium;

import java.util.*;

/**
 * Author:maslke
 * Date:2017/9/2
 * Version:0.0.1
 * 15. 3Sum
 */
public class lc15 {
    Map<String, Integer> map;
    public List<List<Integer>> threeSum(int[] nums) {
        map = new HashMap<String, Integer>();
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> list = twoSum(nums, i);
            ret.addAll(list);
        }
        return ret;
    }

    private List<List<Integer>> twoSum(int[] nums, int inx) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int length = nums.length;
        int i = inx + 1, j = length - 1;
        int target = -1 * nums[inx];
        while (i < j) {
            int v1 = nums[i];
            int v2 = nums[j];
            if (v1 + v2 > target) {
                j--;
            } else if (v1 + v2 < target) {
                i++;
            } else {
                if (!map.containsKey(nums[inx] + "" + nums[i] + "" + nums[j])) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[inx]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    ret.add(list);
                    map.put(nums[inx] + "" + nums[i] + "" + nums[j], 1);
                }

                i++;
                j--;
            }
        }
        return ret;
    }
}
