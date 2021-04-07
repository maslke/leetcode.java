package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/subsets-ii/
// 90.子集 II
public class lc90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        List<Integer> list2 = new ArrayList<>();
        list2.add(nums[0]);
        list.add(list2);
        int prev = 1;
        int len = list.size();
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> list3 = new ArrayList<>();
            if (nums[i] == nums[i - 1]) {
                for (int j = len - 1; j >= prev; j--) {
                    List<Integer> ls = new ArrayList<>(list.get(j));
                    ls.add(nums[i]);
                    list.add(ls);
                }
            }
            else {
                for (List<Integer> ls : list) {
                    List<Integer> temp = new ArrayList<>(ls);
                    temp.add(nums[i]);
                    list3.add(temp);
                }
            }
            list.addAll(list3);
            prev = len;
            len = list.size();
        }
        return list;

    }
}
