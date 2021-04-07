package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/subsets/
// 78. 子集

public class lc78 {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        List<Integer> list2 = new ArrayList<>();
        list2.add(nums[0]);
        list.add(list2);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> list3 = new ArrayList<>();
            for (List<Integer> ls : list) {
                List<Integer> temp = new ArrayList<>(ls);
                temp.add(nums[i]);
                list3.add(temp);
            }
            list.addAll(list3);
        }
        return list;
    }
}
